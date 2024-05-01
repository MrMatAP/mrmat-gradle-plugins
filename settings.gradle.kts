rootProject.name = "mrmat-gradle-plugins"

include("gradle-mrmat-version-plugin")
project(":gradle-mrmat-version-plugin").projectDir = file("gradle-mrmat-version-plugin")

include("gradle-mrmat-rpm-plugin")
project(":gradle-mrmat-rpm-plugin").projectDir = file("gradle-mrmat-rpm-plugin")

include("gradle-mrmat-helm-plugin")
project(":gradle-mrmat-helm-plugin").projectDir = file("gradle-mrmat-helm-plugin")

include("gradle-mrmat-container-plugin")
project(":gradle-mrmat-container-plugin").projectDir = file("gradle-mrmat-container-plugin")

include("gradle-mrmat-ansible-plugin")
project(":gradle-mrmat-ansible-plugin").projectDir = file("gradle-mrmat-ansible-plugin")

include("gradle-mrmat-conventions")
project(":gradle-mrmat-conventions").projectDir = file("gradle-mrmat-conventions")
