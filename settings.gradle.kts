pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "firstDemo"
include(":app")
include(":mod2demo1")
include(":mod2demo2")
include(":mod2demo3")
include(":mod2tpBonus")
include(":mod2demo4")
include(":mod3demo1")
include(":mod3demo2")
include(":mod3demo3")
include(":mod3demo4")
include(":mod3demo5")
include(":mod4demo1")
include(":mod4demo2")
include(":mod4tp1")
include(":mod4demo3")
include(":mod5demo1")
include(":mod5demo2")
include(":mod5demo3")
include(":mod5demo4")
include(":mod5demo5")
include(":mod6demo1")
include(":mod6demo2")
include(":mod6demo3")
include(":mod7demo1")
