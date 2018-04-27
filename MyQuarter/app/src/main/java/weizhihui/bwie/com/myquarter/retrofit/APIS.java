package weizhihui.bwie.com.myquarter.retrofit;

/**
 * Created by QinQinBaoBei on 2018/1/22.
 */

public interface APIS {
  //  公共参数：token=、source=android、appVersion=101
    //轮播图
  String carousel="quarter/getAd";
    //登录
     String login="user/login";
     //注册
     String register="quarter/register";
    //忘记密码
    String forgePwd="quarter/resetPass";
    //https://www.zhaoapi.cn/quarter/resetPass   修改密码
    String resetPass="quarter/resetPass";


    //上传头像
    String iconUp ="file/upload";
    //用户信息
    String userInfo="user/getUserInfo";
    //修改名称
    String updateName="user/updateNickName";
    //发布段子
    String pulish="quarter/publishJoke";
    //获取段子列表
    String getJokes="quarter/getJokes";

    //视频列表
  //https://www.zhaoapi.cn/quarter/getVideos?&source=android&appVersion=101
  String video ="quarter/getVideos";
  //获取关注列表
  //https://www.zhaoapi.cn/quarter/getFollowUsers?uid=1701&token=E6C4C1B581A506F2F4D6748B3649AD3C&source=android&appVersion=101
   String follow="quarter/getFollowUsers";
    //点击关注
  String clickfollow="quarter/follow";
}
