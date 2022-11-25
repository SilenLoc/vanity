@_list:
	just --list --unsorted

alias c := check

alias r := run

bt := '0'

export RUST_BACKTRACE := bt

log := "warn"

export JUST_LOG := log

check:
    ./gradlew check


run:
    ./gradlew --stop
    ./gradlew -p app run