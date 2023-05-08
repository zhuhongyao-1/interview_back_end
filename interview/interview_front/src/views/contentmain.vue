<template>
  <div>
    <Header></Header>
    <el-container>
      <el-main>
        <div class="box_card">
          <el-card
            class="box-card"
            :body-style="{ borderBottom: '1px solid #fff' }"
          >
            <div slot="header" class="clearfix">
              <div class="card_top">
                <ul>
                  <li>{{ subjecttype }}</li>
                  <li>|</li>
                  <li>
                    <el-tag type="success">{{ tag }}</el-tag>
                  </li>
                </ul>
              </div>
              <i
                class="el-icon-edit"
                style="float: right; padding: 3px 0"
                type="text"
              ></i>
            </div>
            <div class="card_main">
              <div class="card_main-inside">
                <div class="card_main-inside-header" v-html="titleName"></div>
                <div class="card_main-inside-header" v-html="titlevalue"></div>
                <div class="card_main-inside-btn">
                  <div class="card_main-inside-btn-inside">
                    <!-- <el-button  type="primary"  @click="font">文字解析</el-button> -->
                    <!-- <el-button type="primary" icon="el-icon-search">搜索</el-button> -->
                  </div>
                </div>
              </div>
            </div>
          </el-card>
          <div class="card-botton">
            <div class="card-botton-inside">
              <ul>
                <li style="border-right: 1px solid">
                  <el-link
                    icon="el-icon-star-off"
                    :underline="a"
                    @click="collecttion"
                    >收藏</el-link
                  >
                </li>
                <li style="border-right: 1px solid">
                  <el-link icon="el-icon-time" :underline="false" @click="yudao"
                    >遇到</el-link
                  >
                </li>
                <li style="border-right: 1px solid">
                  <el-link
                    icon="el-icon-chat-round"
                    :underline="false"
                    @click="share"
                    >分享</el-link
                  >
                </li>
                <!-- <li> <el-link icon="el-icon-c-scale-to-original">操作</el-link></li> -->
              </ul>
            </div>
          </div>
        </div>
        <div class="comment-main">
          <el-card :body-style="{ 'text-align': 'left', padding: '0 20px' }">
            <div slot="header">
              <el-tabs v-model="activeName" @tab-click="handleClick">
                <el-tab-pane label="用户管理" name="first"
                  >用户管理</el-tab-pane
                >
                <!-- <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane> -->
              </el-tabs>
            </div>
            <div class="comment-body">
              <div class="comment-body-header">
                <div class="comment-body-header-inside">
                  <div class="comment-body-header-inside-header">
                    <span class="comment-body-header-inside-answer"
                      >{{ comment_reply.length }}个回答</span
                    >
                    <span
                      ><el-button type="primary" @click="hotvalue"
                        >最热</el-button
                      ><el-button type="primary" @click="newnum"
                        >最新</el-button
                      ></span
                    >
                    <span
                      ><el-button type="primary" @click="answer"
                        >写回答
                      </el-button></span
                    >
                  </div>
                  <div
                    class="content-main-main"
                    v-for="item in comment_reply"
                    :key="item.id"
                  >
                    <div class="user-information">
                      <div class="user-information-inside">
                        <div class="block">
                          <el-avatar
                            :size="small"
                            :src="item.headPortrait"
                          ></el-avatar>
                        </div>
                        <div class="user-information-main">
                          <!-- <div class="user-information-main-top"><span>java</span><span><el-tag size="mini">{{item.Grade_main}}</el-tag></span></div> -->
                          <div>
                            <span>{{ item.commentTime }}</span>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="content-inside">
                      <ul ref="conentimg">
                        <!-- <li>title:{{item.comment_title}}</li> -->
                        <li>主要内容:{{ item.commentContent }}</li>
                        <li v-if="item.commentImg && item.commentImg != ``">
                          <img :src="item.commentImg" alt="" />
                        </li>
                      </ul>
                    </div>
                    <div class="dianzan">
                      <div class="dianzan-inside" style="width: 400px">
                        <span
                          ><el-button
                            type="primary"
                            icon="el-icon-thumb"
                            @click="thumbs(item)"
                            >{{ item.thumbs }}</el-button
                          ></span
                        >

                        <el-link @click="huif(item)">回复 </el-link>

                        <el-dialog title="回复" :visible.sync="huifVisible">
                          <div>
                            <textarea
                              name=""
                              id="onetext"
                              cols="30"
                              rows="10"
                              ref="comment"
                              v-model="replyValue"
                            ></textarea>

                            <div style="text-align: right">
                              <el-button type="text" @click="open(item)"
                                >点赞回复</el-button
                              ><el-button type="text" @click="cancel(item)"
                                >取消</el-button
                              >
                            </div>
                          </div></el-dialog
                        >
                      </div>
                    </div>
                    <div
                      class="thumb"
                      v-for="itema in item.replyVos"
                      :key="itema.id"
                    >
                      <div class="thumb-inside">
                        <div class="thumb-inside-toux">
                          <div class="block">
                            <el-avatar
                              :size="small"
                              :src="itema.headPortrait"
                            ></el-avatar>
                            <!-- 服务器图片报错 -->
                          </div>
                          <div class="all">
                            <div>
                              <span>{{ itema.username }}</span>
                            </div>
                            <div class="huifuvalue">
                              <span>{{ itema.replyContent }}</span>
                            </div>
                          </div>
                        </div>
                        <div class="timeandhuif">
                          <span>{{ itema.replyTime }}</span
                          ><span
                            class="timeandhuif-btn"
                            @click="huifbtn"
                          ></span>
                        </div>
                        <div class="huifshow">
                          <div>
                            <textarea
                              name=""
                              id=""
                              cols="143"
                              rows="5"
                            ></textarea>
                          </div>
                          <div style="text-align: right">
                            <el-button type="primary">回复</el-button
                            ><el-link type="primary" @click="cancel(item)"
                              >取消</el-link
                            >
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>

                  <el-dialog title="写回答" :visible.sync="dialogTableVisible">
                    <!-- <input type="text" name="" id="" placeholder="请输入回答的标题" v-model="titlenew"> -->
                    <el-input
                      type="textarea"
                      autosize
                      placeholder="请输入回答的内容"
                      v-model="insertReply"
                    >
                    </el-input>
                    <el-upload
                      class="upload-demo"
                      action="http://localhost:3001/users/pictureUpload"
                      :on-preview="handlePreview"
                      :on-remove="handleRemove"
                      :on-success="success"
                      :file-list="fileList"
                      list-type="picture"
                      :data="{ module: 'commentImg' }"
                    >
                      <el-button size="small" type="primary"
                        >点击上传</el-button
                      >
                      <div slot="tip" class="el-upload__tip">
                        只能上传jpg/png文件，且不超过500kb
                      </div>
                    </el-upload>
                    <span slot="footer" class="dialog-footer">
                      <el-button @click="dialogTableVisible = false"
                        >取 消</el-button
                      >
                      <el-button type="primary" @click="queding"
                        >确 定</el-button
                      >
                    </span>
                  </el-dialog>
                </div>
              </div>
            </div>
          </el-card>
        </div>
      </el-main>
      <el-aside style="width: 520px">
        <div class="card-right-header">
          <el-card :body-style="{ 'text-align': 'left' }">
            <div slot="header">题目信息</div>
            <div class="subject-conetnet">
              <!-- <div class="subject-conetnet-inside" v-for="item in subject_information" :key="item.id"> -->
              <div>
                <span>浏览数：</span
                ><span>{{ subject_information.pageViews }}</span>
              </div>
              <div>
                <span>发布时间：</span
                ><span>{{ subject_information.createTime }}</span>
              </div>
              <div>
                <ul class="toux">
                  <li>上传者：</li>
                  <li>
                    <el-avatar
                      :size="30"
                      :src="subject_information.headUrl"
                    ></el-avatar>
                  </li>
                  <li>{{ subject_information.username }}</li>
                  <li>
                    <el-tag type="success">{{
                      subject_information.tag
                    }}</el-tag>
                  </li>
                  <!-- <li><el-tag type="success">v3</el-tag></li>
                <li><el-tag type="success">v3</el-tag></li> -->
                </ul>
              </div>
              <div>
                <span>收藏人数: </span
                ><span>{{ subject_information.collectionNumber }}</span
                ><el-button class="subject-btn" @click="myencounter"
                  >我遇到过</el-button
                >
              </div>
              <!-- </div> -->
            </div>
          </el-card>
        </div>
        <div>
          <el-card>
            <div slot="header">相似题目</div>
            <div>
              <div class="similar-card">
                <div
                  class="similar-card-inside"
                  v-for="card in cardold"
                  :key="card.id"
                >
                  <div class="similar-card-inside-content">
                    <div
                      class="transfrom"
                      v-html="card.titleName"
                      @click="skip(card)"
                    ></div>
                    <div class="similar-tag">
                      <el-tag type="">{{ card.tag }}</el-tag>
                    </div>
                    <div>
                      <ul class="similar-subject">
                        <li>{{ card.questionType }}</li>
                        <li
                          style="
                            border-left: 1px solid;
                            border-right: 1px solid;
                            text-align: center;
                          "
                        >
                          {{ card.difflculty }}
                        </li>
                        <li style="text-align: right; width: 200px">
                          {{ card.createTime }}
                        </li>
                      </ul>
                    </div>
                    <div class="card-edit-father">
                      <ul class="card-edit">
                        <li>
                          <el-link icon="el-icon-edit">{{
                            card.pageViews
                          }}</el-link>
                        </li>
                        <li>
                          <el-link icon="el-icon-edit">{{
                            card.collectionNumber
                          }}</el-link>
                        </li>
                        <li>
                          <el-link icon="el-icon-edit">{{
                            card.messageNumber
                          }}</el-link>
                        </li>
                        <!-- <li><el-link icon="el-icon-edit">{{card.yudao}}</el-link></li> -->
                      </ul>
                      <el-button type="primary" size="mini">选题</el-button>
                    </div>
                  </div>
                </div>
                <!-- <div class="similar-card-inside">
                           <div class="similar-card-inside-content">
                            <div><a >什么是token</a></div>
                            <div class="similar-tag"><el-tag type="">最新</el-tag><el-tag type="">最新</el-tag><el-tag type="">最新</el-tag></div>
                            <div>
                                <ul class="similar-subject">
                            <li>简单题</li>
                            <li style="border-left:1px solid;border-right:1px solid;text-align:center">简单题</li>
                            <li style="text-align:right">简单题</li>
                            </ul>
                            </div>
                            <div class="card-edit-father">
                                <ul class="card-edit">
                                    <li><el-link icon="el-icon-edit">编辑</el-link></li>
                                    <li><el-link icon="el-icon-edit">编辑</el-link></li>
                                    <li><el-link icon="el-icon-edit">编辑</el-link></li>
                                    <li><el-link icon="el-icon-edit">编辑</el-link></li>
                                </ul>
                                <el-button type="primary" size="mini">选题</el-button>
                                </div>
                        </div>
                    </div> -->
                <!-- <div class="similar-card-inside">
                           <div class="similar-card-inside-content">
                            <div><a >什么是token</a></div>
                            <div class="similar-tag"><el-tag type="">最新</el-tag><el-tag type="">最新</el-tag><el-tag type="">最新</el-tag></div>
                            <div>
                                <ul class="similar-subject">
                            <li>简单题</li>
                            <li style="border-left:1px solid;border-right:1px solid;text-align:center">简单题</li>
                            <li style="text-align:right">简单题</li>
                            </ul>
                            </div>
                            <div class="card-edit-father">
                                <ul class="card-edit">
                                    <li><el-link icon="el-icon-edit">编辑</el-link></li>
                                    <li><el-link icon="el-icon-edit">编辑</el-link></li>
                                    <li><el-link icon="el-icon-edit">编辑</el-link></li>
                                    <li><el-link icon="el-icon-edit">编辑</el-link></li>
                                </ul>
                                <el-button type="primary" size="mini">选题</el-button>
                                </div>
                        </div>
                    </div> -->
              </div>
            </div>
          </el-card>
        </div>
      </el-aside>
    </el-container>

    <!-- <img :src="require(`../assets/img/${abs}`)" alt=""> -->

    <floor></floor>
  </div>
</template>

<script>
import "../css/contentmain.css";
import Header from "../components/header.vue";
export default {
  components: { Header },
  name: "WorkspaceJsonContentmain",

  data() {
    return {
      titleId: null,
      subject_information: "",
      analysis: "",
      arrall: [],
      arr: [],
      comment_reply: {},
      usertag: "",
      views: "",
      imgtoux: "qq.jpg",
      titlevalue: "",
      tag: "",
      subjecttype: "",
      titleName: "",
      xiao: "small",
      img: "",
      contentold: "",
      small: "small",
      userimg:
        "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      titlenew: "",
      title: "",
      maincontent: "",
      abs: "qq.jpg",
      fileList: [],
      insertReply: "",
      a: false,
      circleUrl: "",
      activeName: "second",
      dialogTableVisible: false,
      formLabelWidth: "120px",
      releasetime: "",
      yudaonum: "",
      cardold: "",
      conent_img: "",
      thumbsvalue: "",
      collectionvalue: "",
      collectionuse: "",
      commentImg: "",
      thumbsFlags: true,
      huifVisible: false,
      replyValue: "",
      commentId: "",
    };
  },

  mounted() {
    this.getCurTitle();

    this.getComment("hot");
    // this.Id = this.$route.query.id;
    //   console.log(this.$cookies.get("title"),1111111)
    // console.log(this.$store.state.title,11111111)

    //     this.$http({
    //         url:"http://localhost:3001/users/selecttitle",
    //         method:"get",
    //         params:{
    //             title:this.$cookies.get("title")
    //         }
    //     }).then((res) => {
    //         this.subject_information = res.data,
    //         window.sessionStorage.setItem("title_username",res.data[0].username)
    //         window.sessionStorage.setItem("title_img",res.data[0].img)
    //         // console.log(res),
    //         this.subjecttype = res.data[0].subjecttype,
    //         this.tag = res.data[0].tag,
    //         this.titlevalue = res.data[0].title,
    //         this.collectionvalue = res.data[0].collection,
    //         this.imgtoux = res.data[0].img,
    //         this.views = res.data[0].views,
    //         this.releasetime = res.data[0].time,
    //         this.yudaonum = res.data[0].yudao,
    //         this.usertag = res.data[0].tag,
    //         this.analysis = res.data[0].analysis
    //           this.$http({
    //                 url:"http://localhost:3001/users/similar",
    //                 method:"get",
    //                 params:{
    //                     // title:this.$cookies.get("title"),
    //                     tag:this.tag
    //                 //   iscollection:true,
    //                 //   iscollectionusername:this.$cookies.get("username")
    //                 },
    //             }).then((res) => {
    //                 // console.log(res,1111111111111),
    //                 this.cardold = res.data
    //                 // ,console.log(this.cardold)
    //             }).catch((err) => {
    //                 console.log(err)
    //             })
    //     }).catch((err) => {
    //             console.log(err)
    //     });
  },

  watch: {
    // comment_reply:function(newvalue,old){
    //     // console.log(newvalue,old,222)
    //    }
  },

  methods: {
    getComment(orderType) {
      this.$http({
        url: "http://localhost:3001/remark/getRemark",
        method: "get",
        params: {
          titleId: this.getCurTitleId(),
          orderType: orderType,
        },
      })
        .then((res) => {
          this.comment_reply = res.data.data;
          console.log("comment", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getCurTitleId() {
      let geturl = window.location.href;
      let getqyinfo = geturl.split("?")[1]; //qycode=1001&qyname=%E4%BC%81%E4%B8%9A%E5%BF%99   截取到参数部分
      let getqys = new URLSearchParams("?" + getqyinfo); //将参数放在URLSearchParams函数中
      return getqys.get("id"); //1001
    },
    getCurTitle() {
      this.titleId = this.getCurTitleId();
      // console.log(this.$refs.subjectref)
      this.$http({
        url: "http://localhost:3001/title/getTitleOne",
        method: "get",
        params: {
          titleId: this.titleId,
        },
      })
        .then((res) => {
          console.log(res.data.data);
          this.subjecttype = res.data.data.questionType;
          this.tag = res.data.data.tag;
          this.titlevalue = res.data.data.explains;
          this.titleName = res.data.data.titleName;

          this.subject_information = res.data.data;

          this.cardold = res.data.data.titleList;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    skip(item) {
      console.log("item", item);
      this.$router.push("/contentmain?id=" + item.id);
      this.getCurTitle();
    },
    font() {
      this.$alert(this.analysis, {
        confirmButtonText: "确定",
      });
    },
    //我遇到过
    myencounter() {
      this.yudao();
    },
    share() {
      // console.log(window.location.href)
      this.$message.success("分享请复制网址" + "--" + window.location.href);
    },
    thumbs(value) {
      //    console.log(value.thumbs_up_main)
      console.log("value", value);
      if (!this.thumbsFlags) {
        this.thumbsFlags = true;
        value.thumbs--;
      } else {
        this.thumbsFlags = false;
        value.thumbs++;
      }

      this.$http({
        url: "http://localhost:3001/remark/updateThumbs",
        method: "get",
        params: {
          thumbsCount: value.thumbs,
          remarkId: value.id,
        },
      })
        .then((res) => {
          console.log(res);
          //     this.$message.success("点赞成功");
          //    console.log(res,"00000000000"),
          //    this.comment_reply = res.data; //comment_reply赋值
        })
        .catch((err) => {
          console.log(err);
        });

      //    if(value.head_portrait_main)
      //    console.log(this.comment_reply)
      //    for (const num in this.comment_reply) {
      //     if(value ===this.comment_reply[num]){
      //         if(this.comment_reply[num].thumbs_up_main === value.thumbs_up_main +1){
      //             console.log(this.comment_reply[num].thumbs_up_main)
      //             console.log(value.thumbs_up_main,2222)
      //             console.log(a,444)
      //              this.comment_reply[num].thumbs_up_main ++
      //         }else{
      //             console.log(2222)
      //         }
      //         return
      //     }
      //         console.log("wu")
      //    }
    },
    hotvalue() {
      this.getComment("hot");
    },
    newnum() {
      this.getComment("new");
    },
    yudao() {
      this.$http({
        url: "http://localhost:3001/users/yudaoadd",
        method: "get",
        params: {
          title: this.$cookies.get("title"),
          //   iscollection:true,
          //   iscollectionusername:this.$cookies.get("username")
        },
      })
        .then((res) => {
          console.log(res);

          if (this.thumbsvalue > 0) {
            this.yudaonum--;
            this.thumbsvalue--;
            this.$message.warn("请不要多次点击");
          } else {
            this.yudaonum++;
            this.thumbsvalue++;
            this.$message.success("遇到过一次");
          }
        })
        .catch((err) => {
          console.log(err),
            this.$message.error("点击失败了，稍后重试或者你点了两次");
        });
    },
    collecttion() {
      if (this.collectionuse > 0) {
        this.collectionvalue--;
        this.collectionuse--;
        this.$http({
          url: "http://localhost:3001/users/decrCollection",
          method: "get",
          params: {
            userId: this.$cookies.get("userId"),
            titleId: this.titleId,
          },
        })
          .then((res) => {
            console.log(res);
            this.subject_information.collectionNumber =
              res.data.data.collectionNumber;
          })
          .catch((err) => {
            console.log(err);
          });
        this.$message.warning("已取消收藏");
      } else {
        this.collectionvalue++;
        this.collectionuse++;
        this.$http({
          url: "http://localhost:3001/users/incrCollection",
          method: "get",
          params: {
            userId: this.$cookies.get("userId"),
            titleId: this.titleId,
          },
        })
          .then((res) => {
            console.log(res.data.data);
            this.subject_information.collectionNumber =
              res.data.data.collectionNumber;
            // res.data.data.collectionNumber
          })
          .catch((err) => {
            console.log(err);
          });
        this.$message.success("收藏成功+1");
      }
    },
    cancel(itema) {
      console.log(itema);
      this.huifVisible = false;
    },
    huifbtn() {
      var onetest = document.querySelector(".huifshow");
      onetest.style.display = "block";
    },
    huif(item) {
      this.huifVisible = true;
      this.commentId = item.id;
      console.log("item", item);
    },
    open(shu) {
      console.log("shu", shu);
      //   console.log(a)
      this.$confirm("是否回复", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$http
            .post(
              //请求的url
              "http://localhost:3001/reply/reply",
              //请求参数，不能以get请求方式写：{params: {userName: "root123", passWord: "root123"}}
              {
                remarkId: this.commentId,
                replyContent: this.replyValue,
              },
              //解决跨域问题，不加无法跨域
              { emulateJSON: true }
            )
            .then(
              (res) => {
                console.log(res), this.getComment("hot");
              },
              (res) => {
                console.log(res);
              }
            );

          this.$message({
            type: "success",
            message: "回复成功!",
          });
          this.huifVisible = false;
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消回复",
          });
        });
    },
    success(file) {
      console.log("file", file);
      this.commentImg = file.data;
    },
    queding() {
      (this.dialogTableVisible = false), (this.titleId = this.getCurTitleId());

      this.$http
        .post(
          //请求的url
          "http://localhost:3001/remark/comment",
          //请求参数，不能以get请求方式写：{params: {userName: "root123", passWord: "root123"}}
          {
            userId: this.$cookies.get("userId"),
            titleId: this.titleId,
            commentContent: this.insertReply,
            commentImg: this.commentImg,
          },
          //解决跨域问题，不加无法跨域
          { emulateJSON: true }
        )
        .then(
          (res) => {
            this.$message.success("评论成功，他她会看到的");
            console.log(res),
              //   this.comment_reply = res.data.data//comment_reply赋值
              //         for(var i=0;i<=this.comment_reply.length-1;i++){
              //         // console.log(this.comment_reply[i],'222222222222')
              //         this.comment_reply[i].index = i
              //    }
              //    this.$forceUpdate()
              this.getComment("hot");
          },
          (res) => {
            console.log(res);
          }
        );
    },
    handleRemove(file, fileList) {
      console.log(file, fileList, "yi");
    },
    handlePreview(file) {
      console.log(file, "chu");
    },
    // open(){
    //     console.log(11111111111111111)
    // },
    handleClick(tab, event) {
      console.log(tab, event);
    },
    answer() {
      this.dialogTableVisible = !this.dialogTableVisible;
      //  console.log(11)
      //  this.$http({
      //     url:"http://localhost:3001/toux",
      //     methods:"get"
      // }).then((res) => {
      //     console.log(res),this.abs = res.data[0].img
      // }).catch((err) => {
      //     console.log(err)
      // });
      //  this.$http({
      //     url:"http://localhost:3001/"
      //  })
    },
  },
};
</script>   

<style lang="css" scoped>
.transfrom:hover {
  color: #1890ff;
}

/* .el-tag{
    height: 20px;
    line-height: 20px;
 } */
</style>