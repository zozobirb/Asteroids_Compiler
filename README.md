Glib_Gloob Compiler Project
===========================

1. Assumptions / Pre-installed Dependencies
------------------------------------------
The following are assumed to already be installed on the grader's system:

- Java JDK (version 8 or higher)
- Bash shell (for running the provided script)
- A Unix-like environment (Linux / macOS).
  (Windows users can use WSL or Git Bash)
- Git (for cloning the repository)

All required libraries (e.g., ANTLR runtime, Gson) are included in the `lib/` directory.


2. Cloning the Repository
-------------------------
To obtain the project, run:

    git clone https://github.com/zozobirb/Asteroids_Compiler.git
    cd Asteroids_Compiler


3. Installing Dependencies
--------------------------
No additional installation is required if the above tools are already available.

To verify Java is installed:
    java -version


4. Building the Project
-----------------------
To compile the project, run:

    javac -cp "lib/*" -d bin src/*.java


5. Running the System
---------------------
Manual run:

    java -cp "bin:lib/*" Driver "FETCH asteroid(id=5)"


6. Example
----------
Example query:

    FETCH asteroid(id=5)

The result will be printed to the terminal.

7. API Key Configuration
------------------------

This project requires an API key to access the asteroid data service.

Before running, set the API key as an environment variable:

Linux/macOS:
    export API_KEY=your_api_key_here
    Can get an api key through: https://api.nasa.gov/?search=neows#authentication
    OR use: DEMO_KEY

Then run the program (Running the system example)
Note:
- The API key is not included in this repository for security reasons.
- If no key is provided, the program will not run.
