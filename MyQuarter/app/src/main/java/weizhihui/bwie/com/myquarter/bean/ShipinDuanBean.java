package weizhihui.bwie.com.myquarter.bean;

import java.util.List;

/**
 * Created by lenovo on 2018/4/26.
 */

public class ShipinDuanBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"等黑夜问白天，能不能赦免 灰色的人间","createTime":"2018-04-26T13:30:20","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524720620872ljj.jpg","jid":2292,"praiseNum":null,"shareNum":null,"uid":10698,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524711770653head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"他啦咯啦咯啦咯","createTime":"2018-04-26T11:55:34","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247149345122018-04-26_11-46-36.jpg","jid":2291,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"他啦咯啦咯啦咯","createTime":"2018-04-26T11:55:33","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247149330902018-04-26_11-46-36.jpg","jid":2290,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"他啦咯啦咯啦咯","createTime":"2018-04-26T11:55:33","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247149330902018-04-26_11-46-36.jpg","jid":2289,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"他啦咯啦咯啦咯","createTime":"2018-04-26T11:55:31","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247149317462018-04-26_11-46-36.jpg","jid":2288,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"他啦咯啦咯啦咯","createTime":"2018-04-26T11:55:30","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247149307932018-04-26_11-46-36.jpg","jid":2287,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"特特特某嘟嘟","createTime":"2018-04-26T11:47:47","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247144675612018-04-26_11-46-36.jpg","jid":2286,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"特特特某嘟嘟","createTime":"2018-04-26T11:47:47","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247144673422018-04-26_11-46-36.jpg","jid":2285,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"特特特某嘟嘟","createTime":"2018-04-26T11:47:47","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247144672642018-04-26_11-46-36.jpg","jid":2284,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"特特特某嘟嘟","createTime":"2018-04-26T11:47:47","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247144672492018-04-26_11-46-36.jpg","jid":2283,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"}}]
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
         * content : 等黑夜问白天，能不能赦免 灰色的人间
         * createTime : 2018-04-26T13:30:20
         * imgUrls : https://www.zhaoapi.cn/images/quarter/1524720620872ljj.jpg
         * jid : 2292
         * praiseNum : null
         * shareNum : null
         * uid : 10698
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524711770653head_icon.jpg","nickname":null,"praiseNum":"null"}
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
             * icon : https://www.zhaoapi.cn/images/1524711770653head_icon.jpg
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
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

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
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
