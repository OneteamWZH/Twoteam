package weizhihui.bwie.com.myquarter.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/4/27.
 */

public class DuanBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"罩得住","createTime":"2018-04-27T09:26:52","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524792412325images.jpg|https://www.zhaoapi.cn/images/quarter/1524792412325images.jpg","jid":2354,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-27T09:26:52","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524792412169images.jpg|https://www.zhaoapi.cn/images/quarter/1524792412185images.jpg","jid":2353,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"张狂不是我的本性","createTime":"2018-04-27T08:52:13","imgUrls":null,"jid":2352,"praiseNum":null,"shareNum":null,"uid":12574,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1523418069882aa.jpg","nickname":"大航","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-27T08:46:40","imgUrls":null,"jid":2351,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-27T08:46:36","imgUrls":null,"jid":2350,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-27T08:43:56","imgUrls":null,"jid":2349,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-27T08:41:13","imgUrls":null,"jid":2348,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"111","createTime":"2018-04-26T22:24:45","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247526857212018-04-25_15-50-11.jpg|https://www.zhaoapi.cn/images/quarter/15247526857212018-04-25_15-57-35.jpg","jid":2347,"praiseNum":null,"shareNum":null,"uid":3026,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524033488755test.png","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:58:09","imgUrls":null,"jid":2346,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}},{"commentNum":null,"content":"罩得住","createTime":"2018-04-26T21:58:06","imgUrls":null,"jid":2345,"praiseNum":null,"shareNum":null,"uid":12575,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 罩得住
         * createTime : 2018-04-27T09:26:52
         * imgUrls : https://www.zhaoapi.cn/images/quarter/1524792412325images.jpg|https://www.zhaoapi.cn/images/quarter/1524792412325images.jpg
         * jid : 2354
         * praiseNum : null
         * shareNum : null
         * uid : 12575
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1522223095271img.png","nickname":"王奎奎","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private String imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(String imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1522223095271img.png
             * nickname : 王奎奎
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
