# TDD, BDD and Unit Testing

## MVP 
See UK Child Benefit System Scenario Document for context

> 1. Record the acceptance criteria for this scenario.
> 
>  ### Acceptance criteria 
> 
>   AC1 -  A child under the age of 16 is always eligible for Child Benefit.
> 
>   AC2 - A child aged between 16 and 19 is eligible only if in approved education.
> 
>   AC3 - A child aged 20 or older is not eligible, regardless of circumstances.
> 
>   AC4 - The eldest or only eligible child receives £26.05 per week.
> 
>   AC5 - Each additional eligible child receives £17.25 per week.
> 
>   AC6 - Families with income ≤ £50,000 receive full benefit.
> 
>   AC7 - Families earning £50,001–£100,000 with ≥2 children receive £5.77 per child per week.
> 
>   AC8 - Families earning £50,001–£100,000 with <2 children receive £2.88 per child per week.
> 
>   AC9 - Families earning >£100,000 are not eligible for Child Benefit.
> 
>   AC10 -  AC10: Families with a special circumstance (e.g. disabled child) receive an additional £3.85 per eligible 
>           child per week (if within income limits).
> 
>   
>   #### Pre conditions
> 
>  - Benefit amounts must be calculated weekly.
>  - A child must be both eligible by age/education and included in family circumstances to count toward benefit.
>  - The eldest child is determined only among eligible children.


2. Consider the test cases that will be used to test the developer’s code. These table
headings could be a good start:

| Test Case ID | Description                                                        | Income   | Child Ages (Edu Status)           | Special Circumstance | Expected Benefit (weekly)       | Related ACs        |
| ------------ | ------------------------------------------------------------------ | -------- | --------------------------------- | -------------------- | ------------------------------- | ------------------ |
| TC1          | One child under 16, income below £50k                              | £45,000  | 1 child age 10                    | No                   | £26.05                          | AC1, AC4, AC6      |
| TC2          | One child aged 17, **in** approved education                       | £40,000  | 1 child age 17 (in education)     | No                   | £26.05                          | AC2, AC4, AC6      |
| TC3          | One child aged 17, **not** in approved education                   | £40,000  | 1 child age 17 (not in education) | No                   | £0.00                           | AC2, AC6           |
| TC4          | One child age 20, income below threshold                           | £45,000  | 1 child age 20                    | No                   | £0.00                           | AC3, AC6           |
| TC5          | Two eligible children, income below £50k                           | £48,000  | 1 child age 10, 1 child age 7     | No                   | £43.30 (26.05 + 17.25)          | AC1, AC4, AC5, AC6 |
| TC6          | Three eligible children, income between £50,001–£100k              | £60,000  | 1 child age 12, 1 age 15, 1 age 5 | No                   | £17.31 (3 × 5.77)               | AC7                |
| TC7          | One eligible child, income between £50,001–£100k                   | £75,000  | 1 child age 8                     | No                   | £2.88                           | AC8                |
| TC8          | One eligible child, income above £100k                             | £120,000 | 1 child age 10                    | No                   | £0.00                           | AC9                |
| TC9          | Two eligible children, with **special circumstance**, income <£50k | £48,000  | 1 child age 6, 1 age 4            | Yes                  | £50.80 (26.05 + 17.25 + 2×3.85) | AC5, AC6, AC10     |
| TC10         | Two eligible children, **special circumstance**, income >£100k     | £120,000 | 1 child age 3, 1 age 2            | Yes                  | £0.00                           | AC9, AC10          |




>
> 3. Turn your test cases into BDD scenarios using Gherkin Syntax.
> 
> #### Background:
>   - Benefit amounts are calculated weekly
>   - A child must be eligible by age and education to count toward benefit
>   - The eldest child is determined only among eligible children
> 
> #### Scenario 1 : Child under 16 is always eligible for Child Benefit
>  - Given a family with one child aged 10
>  - And a family income of £45000
>  - When they apply for the Child Benefit
>  - Then they should receive £26.05 per week
>
> #### Scenario 2 : Family with one child aged 17 in approved education and income below £50,000
>  - Given a family with one child aged 17 in approved education
>  - And an annual income of £40000
>  - When they apply for the Child Benefit
>  - Then they should receive £26.05 per week
> 
> #### Scenario 3 : Family with one child aged 17 not in education and income below £50,000
>  - Given a family with one child aged 17 not in approved education
>  - And an annual income of £40000
>  - When they apply for the Child Benefit
>  - Then they should receive £0 per week
> 
> #### Scenario 4 : Family with one child aged 20 and income below £50,000
>  - Given a family with one child aged 20
>  - And an annual income of £45000
>  - When they apply for the Child Benefit
>  - Then they should receive £0 per week
> 
> #### Scenario 5 : Family with two eligible children and income below £50,000
>  - Given a family with one child aged 10 and one child aged 7
>  - And an annual income of £48000
>  - When they apply for the Child Benefit
>  - Then they should receive £43.30 per week
> 
> #### Scenario 6 : Family with three eligible children and income between £50,001–£100,000
>  - Given a famil with three children aged 2,4 and 8
>  - And an annual income of £60000
>  - When they apply for the Child Benefit 
>  - Then they should receive £17.31 per week 
> 
> #### Scenario 7 : Family with one eligible child and income between £50,001–£100,000
>  - Given a family with one child aged 6
>  - And an annual income of £75000
>  - When they apply for Child Benefit
>  - Then they should receive £2.88 per week
> 
> #### Scenario 8 : Family with one eligible child and income above £100,000
>  - Given a family with one child aged 8
>  - And an annual income of £145000
>  - When they apply for the Child Benefit
>  - Then they should receive £0 per week 
> 
> #### Scenario 9 : Two eligible children, special circumstance, income below £50k
>  - Given a family with two children aged 4, 6
>  - And special circumstances apply to both children 
>  - And an annual income of £39000
>  - When they apply for the Child Benefit
>  - Then they should receive £50.80 per week
> 
> #### Scenario 10 : Family with two eligible children including one with a disability and income above £100,000
>  - Given a family with two children aged 4,5
>  - And both have special circumstances applied
>  - And an annual income of 132000
>  - When they apply for Child Benefit
>  - Then they should receive £0 per week 
> 