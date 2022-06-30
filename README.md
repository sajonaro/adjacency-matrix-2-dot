
This application converts an adjacency matrix into .dot file (from graphviz suite) 
Undirected and directed graphs are supported. Check examples below.


links: <br>
https://en.wikipedia.org/wiki/Adjacency_matrix  <br>
http://www.graphviz.org/  <br>

dependencies (see deps.edn for details): <br>
clojar: net.mikera/core.matrix  <br>


== examples == <br>
== ex1 ==

A matrix:

[[ 1 0  1] <br>
 [ 0 1  0] <br>
 [ 1 0  1]]<br>

should be represented as:

graph ex1{
  v1 -- v1 -- v3 ;
  v2 -- v2 ;
  v3 -- v3 ;
}
== end of ex1 ==

== ex2 ==

[[ 0  1  0] <br>
 [ 0  0  1] <br>
 [ 0  0  0]]<br>


should be represented as:

digraph ex1{
  v1 -> v2 -> v3 ;
}

== end of ex2 ==


useful commands 

1) to generate svg out of Dot file use dot utility from graphviz suite as follows:
cd examples && dot -Tsvg ex1.dot > ex1.svg

2) to run application from command line use clj with alias :run defined in deps.edn as follows:
clj -X:run