package json;

import com.google.gson.Gson;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParsingDemo {
    public static void main(String[] args) throws URISyntaxException {

        Path path = Paths.get(JsonParsingDemo.class.getResource("/data.json").toURI());
        System.out.println(path);

        var sb = new StringBuilder();

        try (var fr = new FileReader(path.toFile());
             var br = new BufferedReader(fr)) {


            while(br.ready()) {
                sb.append(br.readLine());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("content: " + sb.toString());

        var gson = new Gson();

        var pageInfo = gson.fromJson(sb.toString(), PageInfo.class);

        for(var pos : pageInfo.getPosts())
            System.out.println(pos.actor_id + ": " + pos.post_id);
    }

    class PageInfo {
        private String pageName;
        private String pagePick;
        private List<Post> posts = new ArrayList<>();

        public String getPageName() {
            return pageName;
        }

        public void setPageName(String pageName) {
            this.pageName = pageName;
        }

        public String getPagePick() {
            return pagePick;
        }

        public void setPagePick(String pagePick) {
            this.pagePick = pagePick;
        }

        public List<Post> getPosts() {
            return posts;
        }

        public void setPosts(List<Post> posts) {
            this.posts = posts;
        }
    }

    class Post {
         private String post_id;
         private long actor_id;

        public String getPost_id() {
            return post_id;
        }

        public void setPost_id(String post_id) {
            this.post_id = post_id;
        }

        public long getActor_id() {
            return actor_id;
        }

        public void setActor_id(long actor_id) {
            this.actor_id = actor_id;
        }
    }
}
