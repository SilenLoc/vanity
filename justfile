@_list:
	just --list --unsorted

alias c := check

alias r := run

bt := '0'


log := "warn"

export JUST_LOG := log

check:
    ./gradlew check


run:
    ./gradlew --stop
    ./gradlew -p app run

publish:
    ./gradlew publish -p framework

publish-dry:
    ./gradlew publish -p framework --dry-run

release *args:
	npm install --no-save @semantic-release/exec conventional-changelog-conventionalcommits
	npx semantic-release {{args}}