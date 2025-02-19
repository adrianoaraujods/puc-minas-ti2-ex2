package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostsDAO extends DAO {
    public PostsDAO() {
        super();
        conectar();
    }

    public boolean insert(Post post) {
        boolean status = true;
        try {
            Statement st = conexao.createStatement();
            String sql = "INSERT INTO post (id, title, createdAt, content) "
                    + "VALUES (" + post.getId() + ", '" + post.getTitle() + "', '"
                    + post.getCreatedAt() + "', '" + post.getContent() + "');";
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        } catch (Exception e) {
            System.err.println(e.getMessage());

            status = false;
        }
        return status;
    }

    public Post get(int id) {
        Post post = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM produto WHERE id=" + id;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                post = new Post(rs.getInt("id"), rs.getString("title"), rs.getLong("createdAt"), rs.getString("content"));
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return post;
    }

    public List<Post> getAll(String orderBy) {
        List<Post> posts = new ArrayList<Post>();

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM post" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Post p = new Post(rs.getInt("id"), rs.getString("title"), rs.getLong("createdAt"), rs.getString("content"));
                posts.add(p);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return posts;
    }

    public boolean update(Post post) {
        boolean status = true;
        try {
            Statement st = conexao.createStatement();
            String sql = "UPDATE post SET title = '" + post.getTitle() + "', createdAt = '"
                    + post.getCreatedAt() + "', content = '" + post.getContent() + "'"
                    + " WHERE id = " + post.getId();
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException u) {
            status = false;
            throw new RuntimeException(u);
        }
        return status;
    }

    public boolean delete(int id) {
        boolean status = true;
        try {
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM post WHERE id = " + id;
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException u) {
            status = false;
            throw new RuntimeException(u);
        }
        return status;
    }
}