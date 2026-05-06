def call(String dockerHubCred, String imageName, String imageTag ){
  echo "This is pushing the Image : ${imageName}:${imageTag} to DockerHub"
  withCredentials(
    [usernamePassword(credentialsId : dockerHubCred,
    usernameVariable : 'USER',
    passwordVariable : 'PASS' )]){
  sh "docker login -u ${USER} -p ${PASS}"
  sh "docker image tag ${imageName}:${imageTag} ${USER}/${imageName}:${imageTag}"
  sh "docker push ${USER}/${imageName}:${imageTag}"
  }
}



// echo 'This is pushing the Image to DockerHub'
//                 withCredentials(
//                     [usernamePassword(credentialsId : 'DockerHubCred',
//                     usernameVariable : 'DockerHubUser',
//                     passwordVariable : 'DockerHubPass')]){
//                 sh "docker login -u ${env.DockerHubUser} -p ${env.DockerHubPass}"
//                 sh "docker image tag notes-app:latest ${env.DockerHubUser}/notes-app:latest"
//                 sh "docker push ${env.DockerHubUser}/notes-app:latest"
