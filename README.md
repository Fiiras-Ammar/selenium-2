# Videos

XPath: https://youtu.be/jDWqhgB7OUU

Page Object model: https://youtu.be/f_1XTDevI_Y

# XPath

XPath is a general language to select elements from XML language.
While the HTML is an XML then we can use the XPath to find elements.

https://www.freeformatter.com/xpath-tester.html

https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/By.html#xpath(java.lang.String)


# Page Object pattern

If we write more test the suites can get harder and harder to understand, so we introduce a level of organizing code.
We say that every page have it's own class that contains the actions that can be done on that page or information that can be claimed.

https://www.selenium.dev/documentation/en/guidelines_and_recommendations/page_object_models/


# Selenium Assignment

## Overview

Your assignment is to write Selenium tests for a publicly available website of your choice. Each student must choose a different website. The website must have a login feature and some basic functionality to test.

## Steps

1. **Reserve your website.** Check the [reserved websites spreadsheet](https://docs.google.com/spreadsheets/d/1pVWcnxBJkw6f9679S2l4ZuaLa-QWQEEYAoFtjM3Bbw4/edit?usp=sharing) to make sure your website is not taken. The spreadsheet also contains last year's choices, those are also unavailable. Then fill out [this form](https://docs.google.com/forms/d/e/1FAIpQLSeDvCWjhM4KrUV_1eQc45taf--5Uz798jruwcFd8vjvXVAyHg/viewform?usp=sf_link) to reserve it.

2. **Fork [this template repository](https://github.com/Hudi89/selenium-assignment-template)** to your own GitHub account. Yes, we are using [GitHub](https://github.com/) this time, not GitLab. This helps build your public developer profile. ([How to fork](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/fork-a-repo))  After forking, go to the **Actions** tab in your fork and enable workflows when prompted.

3. **Write your Selenium tests** and push your code to your forked repository.

4. **Fill in `points.yml`** in the root of your repository. This file contains the full task list with point values. Mark the tasks you have completed. Every time you push, a GitHub Actions CI pipeline will run automatically (similar to the GitLab CI we used in class). **The CI must pass for your submission to be graded.**

5. **Submit your work** [here](https://docs.google.com/forms/d/e/1FAIpQLSd2asaAJwY9K5CSdew_hosIbHKL5KwSNm0CAqwWabSEju0Peg/viewform?usp=sf_link).

If you want to change anything after submitting (e.g. different repository URL), simply submit the form again. The latest submission is always the one that counts.

## About the CI

The CI gives you a quick preview of your grade, but it just reads what you wrote in the YAML. I will check your actual code separately, so don't mark things as done that you haven't actually built. If the CI fails, check that your YAML is properly formatted — you can use [yamllint.com](https://www.yamllint.com/) to verify your syntax.

To check your grade:

- Go to your repository on GitHub;
- Click the Actions tab at the top;
- Click the latest workflow run (top one);
- Open the grade job left side or at the middle;
- Click the `Run python .github/scripts/calculate_grade.py points.yml` step.

Your full grade report is printed there.

## Grading

### Point thresholds

| Grade | Minimum overall points | Minimum advanced points |
|-------|------------------------|-------------------------|
| 2     | 25                     | 0                       |
| 3     | 40                     | 5                       |
| 4     | 60                     | 10                      |
| 5     | 80                     | 20                      |

### Quality requirements (gatekeepers)

No matter how many points you have, the following quality standards apply:

- **Grade 3+**: Code is structured and organized in classes and functions. Unnecessary files are properly ignored (`.gitignore`).
- **Grade 4+**: The above, plus code is readable — every function name describes what it does. Test suite reads like a test description.
- **Grade 5**: The above, plus low code redundancy — minimal duplication.

For example if you do not ignore unnecessary files, you cannot get better than grade 2.

### How this maps to your final course grade

Your assignment grade (1–5) is multiplied by 2 to get your instructor score (0–10) for the final grade calculation. For example, grade 3 on this assignment = 6 points out of 10.

## AI Usage

If you used any AI tools, fill in the ai_usage section in points.yml. This won't affect your grade. However, if you don't declare AI usage but your code clearly looks AI-generated or not your own work, I will ask you to present and explain your solution in a 1-on-1 call.

## Deadline

**May 20, 2026 6:00 AM** Your last commit timestamp matters.

Late submission penalties:

| Submitted by | Penalty |
|-------------|---------|
| May 20, 6:00 AM | No penalty |
| May 27, 6:00 AM | -1 grade |
| June 3, 6:00 AM | -2 grades |
| June 10, 6:00 AM | -3 grades |
| After June 10, 6:00 AM | Not accepted |

### Examples

- You submit on May 20 at 5:45 AM with points for grade 5 → you get grade **5**.
- You submit on May 20 at 6:01 AM with points for grade 5 → you get grade **4** (1 week late).
- You submit on May 27 at 5:59 AM with points for grade 4 → you get grade **3** (1 week late).
- You submit on June 3 at 6:10 AM with points for grade 3 → you get grade **1** (2+ weeks late).
