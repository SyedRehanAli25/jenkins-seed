def environments = ['dev', 'qa', 'prod']
def apps = ['salary', 'attendance', 'employee']

environments.each { env ->
    folder(env) {
        description("Environment folder for ${env}")
    }

    apps.each { app ->
        job("${env}/${app}") {
            description("Job for ${app} in ${env} environment")
            scm {
                git("https://github.com/SyedRehanAli25/Rehan-Repository-1.git")
            }
            triggers {
                scm('H/5 * * * *')
            }
            steps {
                shell("echo Running ${app} in ${env}")
            }
        }
    }
}

