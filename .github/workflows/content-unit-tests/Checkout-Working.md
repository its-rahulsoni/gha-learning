QUES: Makes the latest commit (or PR-specific commit) available for the workflow to act on.

what do u mean by this - there are many branches in the repo, how does the runner knows which specific commit to pick and from which branch ?

---
ANS: This dives into the heart of how GitHub Actions workflows behave!

---

### 💡 Short Answer:

> GitHub Actions **automatically checks out the specific commit** that triggered the workflow — whether it’s from a **pull request**, a **push to a branch**, or any other event.

---

### 🔍 So How Does the Runner Know Which Commit or Branch?

When you set up a workflow like this:

```yaml
on:
  pull_request:
    branches:
      - main
```

This means:

* “Run this workflow when **a pull request is created or updated targeting the `main` branch**.”
* GitHub internally tracks **which commit from the source branch triggered the pull request.**

So, the runner will:

* Checkout the **latest commit of the pull request’s source branch** (not `main`, but the branch where the PR is created from).
* This way, the tests run **on exactly what was changed** in the PR.

---

### 🔧 Internals Behind the Scenes:

GitHub injects context into the workflow:

* `${{ github.ref }}` points to the branch or tag that triggered the workflow
* `${{ github.sha }}` is the **specific commit SHA** that triggered the event

The `actions/checkout` action reads these and does something like:

```bash
git fetch origin
git checkout $GITHUB_SHA
```

So it **does not fetch the whole repo** by default — only the minimal commit needed for that event.

---

### 🧪 Real Example:

If your repo has:

* `main` branch
* `feature/login` branch

And someone opens a pull request from `feature/login → main`, the runner will:

* Checkout the commit from `feature/login` that triggered the PR update
* Test **that exact snapshot** of the code
* It will not run tests on `main` directly unless `main` is the source of the commit

---

### ✅ Summary:

| Trigger Type        | What Code Is Checked Out                          |
| ------------------- | ------------------------------------------------- |
| `push`              | The commit that was pushed                        |
| `pull_request`      | The PR source branch's commit                     |
| `workflow_dispatch` | Whatever branch/commit the user chooses in the UI |

So **you don’t have to tell the runner** explicitly — GitHub does that for you using metadata from the event that triggered the workflow.

Let me know if you'd like to see this behavior in logs or configure custom behavior (e.g. manually checking out a specific branch or commit).
