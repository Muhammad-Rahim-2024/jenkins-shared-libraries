def call(String dockerHubCred, String dockerHubUser, String dockerHubPass, String imageName, String imageTag ){
  echo "This is pushing the Image : ${imageName}:${imageTag} to DockerHub User: ${dockerHubUser}"
  withCredentials(
    [usernamePassword(credentialsId : "${dockerHubCred}",
    usernameVariable : "${dockerHubUser}",
    passwordVariable : "${dockerHubPass}" )]){
  sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  sh "docker image tag ${imageName}:${imageTag} ${dockerHubUser}/${imageName}:${imageTag}"
  sh "docker push ${dockerHubUser}/${imageName}:${imageTag}"
}





// echo 'This is pushing the Image to DockerHub'
//                 withCredentials(
//                     [usernamePassword(credentialsId : 'DockerHubCred',
//                     usernameVariable : 'DockerHubUser',
//                     passwordVariable : 'DockerHubPass')]){
//                 sh "docker login -u ${env.DockerHubUser} -p ${env.DockerHubPass}"
//                 sh "docker image tag notes-app:latest ${env.DockerHubUser}/notes-app:latest"
//                 sh "docker push ${env.DockerHubUser}/notes-app:latest"
            

  
