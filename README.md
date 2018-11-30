# SoftwareTestingWeb

This project test Sisproj website login. Available on link: http://sisproj1.uea.edu.br/index.php?dest=roston

Cases test:

| Case | Login | Password | Result |
|------|-------|----------|--------|
| 1    | BLANK  | BLANK     | GOOD   |
| 2    | NO GOOD  | GOOD     | GOOD   |
| 3    | NO GOOD  | BLANK     | GOOD   |
| 4    | GOOD  | BLANK     | GOOD   |
| 5    | BLANK  | NO GOOD     | GOOD   |
| 6    | NO GOOD  | NO GOOD     | GOOD   |
| 7    | GOOD  | NO GOOD     | GOOD   |
| 8    | BLANK  | GOOD     | GOOD   |

Legend: GOOD: correct login or password; NO GOOD: incorrect login or password; BLANK: filled with nothing on field.