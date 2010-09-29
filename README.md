# Linköping Clojure User Group - Code Examples

This repo contains the following projects:

* bot -- a title-printing IRC bot build on irclj and enlive
* web -- a web app built on moustache, enlive and ring

All code is licenced under the EPL v1.0.

## Usage

The projects use the usual project structure. To start up a repl in <project> with Leiningen, do:

    cd <project>
    lein deps
    lein repl

If you want to use Slime in emacs, replace "lein repl" with "lein swank".
