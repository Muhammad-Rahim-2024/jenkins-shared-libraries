// echo 'This is Cloning the Code'
// git url: "https://github.com/Muhammad-Rahim-2024/django-notes-app.git", branch: "dev"
// echo 'Code Cloning Successfully!'

def call(String gitUrl, String gitBranch){
  echo 'This is Cloning the Code'
  // git url: "${gitUrl}", branch: "${gitBranch}"
  git url: gitUrl, branch: gitBranch
  echo 'Code Cloning Successfully!'  
}
