package com.huanchengfly.tieba.post.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopicDetailBean(
    @SerialName("no")
    val errorCode: Int,
    @SerialName("error")
    val errorMsg: String,
    val data: TopicDetailDataBean,
)

@Serializable
data class TopicDetailDataBean(
    @SerialName("topic_info")
    val topicInfo: TopicInfoBean,
    val user: UserBean,
    val tbs: String,
    @SerialName("relate_forum")
    val relateForum: List<RelateForumBean>,
//    @SerialName("special_topic")
//    val specialTopic: List<SpecialTopicBean>,
    @SerialName("relate_thread")
    val relateThread: RelateThreadBean,
    @SerialName("module_info")
    val moduleInfo: List<ModuleInfoBean> = emptyList(),
    @SerialName("has_more")
    val hasMore: Boolean,
    @SerialName("wreq")
    val wreq: Wreq,
)

/**
 * 话题页模块信息
 *
 * [moduleType] 为 "28" 时是置顶帖模块，其 [threadList] 中的帖子带 "置顶" 标签；
 * "24" 是"热点相关吧"等推荐模块
 */
@Serializable
data class ModuleInfoBean(
    val location: String = "",
    @SerialName("module_type")
    val moduleType: String = "",
    @SerialName("module_name")
    val moduleName: String = "",
    @SerialName("thread_list")
    val threadList: List<ThreadInfoBean> = emptyList(),
)

@Serializable
data class RelateThreadBean(
    @SerialName("thread_list")
    val threadList: List<ThreadBean>,
)

@Serializable
data class Wreq(
    @SerialName("pn")
    val page: Int,
    @SerialName("rn")
    val pageSize: Int,
)

@Serializable
data class ThreadBean(
    @SerialName("feed_id")
    val feedId: Long,
    val source: Int,
    @SerialName("thread_info")
    val threadInfo: ThreadInfoBean,
    @SerialName("user_agree")
    val userAgree: Int,
)

@Serializable
data class TopicInfoBean(
    @SerialName("topic_id")
    val topicId: String,
    @SerialName("topic_name")
    val topicName: String,
    val candle: String,
    @SerialName("topic_desc")
    val topicDesc: String,
    @SerialName("discuss_num")
    val discussNum: Long,
    @SerialName("topic_image")
    val topicImage: String,
    @SerialName("share_title")
    val shareTitle: String,
    @SerialName("share_pic")
    val sharePic: String,
    @SerialName("is_video_topic")
    val isVideoTopic: Int,
    @SerialName("idx_num")
    val idxNum: Int,
)

@Serializable
data class UserBean(
    @SerialName("is_login")
    val isLogin: Boolean,
    val id: Long,
    val uid: Long,
    val name: String,
    @SerialName("name_show")
    val nameShow: String,
    @SerialName("portrait")
    val portraitUrl: String,
)

@Serializable
data class RelateForumBean(
    @SerialName("forum_id")
    val forumId: Long,
    @SerialName("forum_name")
    val forumName: String,
    val avatar: String,
    val desc: String,
    @SerialName("member_num")
    val memberNum: Long,
    @SerialName("thread_num")
    val threadNum: Long,
    @SerialName("post_num")
    val postNum: Long,
)

@Serializable
data class SpecialTopicBean(
    val title: String,
    @SerialName("thread_list")
    val threadList: List<ThreadInfoBean>,
)

@Serializable
data class ThreadInfoBean(
    val id: Long = 0,
    @SerialName("feed_id")
    val feedId: Long = 0,
    val avatar: String = "",
    val title: String? = "",
    @SerialName("tid")
    val threadId: Long = 0,
    @SerialName("forum_id")
    val forumId: Long = 0,
    @SerialName("forum_name")
    val forumName: String = "",
    @SerialName("create_time")
    val createTime: Long = 0,
    @SerialName("last_time")
    val lastTime: String = "",
    @SerialName("last_time_int")
    val lastTimeInt: Long = 0,
    @SerialName("abstract")
    val abstractText: String = "",
    val media: List<MediaBean> = emptyList(),
    @SerialName("media_num")
    val mediaNum: MediaNumBean = MediaNumBean(),
    @SerialName("agree_num")
    val agreeNum: Int = 0,
    @SerialName("reply_num")
    val replyNum: Int = 0,
    @SerialName("share_num")
    val shareNum: Long = 0,
    @SerialName("user_id")
    val userId: Long = 0,
    @SerialName("first_post_id")
    val firstPostId: Long = 0,
    @SerialName("user_agree")
    val userAgree: Int = 0,
    @SerialName("author")
    val author: Author = Author(),
    val agree: Agree = Agree(),
    @SerialName("thread_type")
    val threadType: String = "",
    @SerialName("thread_source")
    val threadSource: Int = 0,
    // 置顶等标签，如 "置顶"
    val tag: String = "",
    // 热评信息
    @SerialName("show_post_info")
    val showPostInfo: ShowPostInfoBean? = null,
)

/**
 * 热评信息（置顶帖等卡片下方的热门评论）
 */
@Serializable
data class ShowPostInfoBean(
    @SerialName("thread_id")
    val threadId: Long = 0,
    @SerialName("post_id")
    val postId: Long = 0,
    @SerialName("user_id")
    val userId: Long = 0,
    @SerialName("author")
    val author: Author? = null,
    val content: String = "",
    @SerialName("agree_num")
    val agreeNum: Int = 0,
    @SerialName("create_time")
    val createTime: String = "",
)



@Serializable
data class Agree(
    @SerialName("agree_num")
    val agreeNum: Int = 0,

    @SerialName("agree_type")
    val agreeType: Int = 0,

    @SerialName("has_agree")
    val hasAgree: Int = 0,
)

@Serializable
data class Author(
    val name: String? = null,
    val id: Long = 0,
    @SerialName("show_nickname")
    val showNickName: String = "",
    @SerialName("name_show")
    val nameShow: String = "",
    val portrait: String = "",
)

@Serializable
data class MediaNumBean(
    val pic: Int = 0,
)

@Serializable
data class MediaBean(
    val type: String = "",
    val width: String = "",
    val height: String = "",
    @SerialName("small_pic")
    val smallPic: String = "",
    @SerialName("big_pic")
    val bigPic: String = "",
    @SerialName("water_pic")
    val waterPic: String = "",
    @SerialName("is_long_pic")
    val isLongPic: Int = 0,
    @SerialName("bsize")
    val bSize: String = "",
)