package com.lwh.whitebook.beans;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
public class ZhiHuDailyNews {


    /**
     * date : 20170221
     * stories : [{"images":["http://pic2.zhimg.com/abbc4338c20e7698b46a81b12a34a941.jpg"],"type":0,"id":9239132,"ga_prefix":"022122","title":"小事 · 误入地下核设施"}]
     */

    private String date;
    private List<Question> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Question> getStories() {
        return stories;
    }

    public void setStories(List<Question> stories) {
        this.stories = stories;
    }

    public static class Question {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "Question{" +
                    "type=" + type +
                    ", id=" + id +
                    ", ga_prefix='" + ga_prefix + '\'' +
                    ", title='" + title + '\'' +
                    ", images=" + images +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ZhiHuDailyNews{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                '}';
    }
}
