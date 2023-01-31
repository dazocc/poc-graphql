package br.com.dazo.pocgraphql.forum;

record Post(String id, String content) {
}

record Comment(String id, String content, String postId) {
}

