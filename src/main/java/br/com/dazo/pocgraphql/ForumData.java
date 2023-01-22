package br.com.dazo.pocgraphql;

record Post(String id, String content) {
}

record Comment(String id, String content, String postId) {
}

