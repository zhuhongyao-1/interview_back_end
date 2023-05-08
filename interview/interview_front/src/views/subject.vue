<template>
  <div>
    <Header :dalist="listdata" ref="header"></Header>
    <el-container>
      <!-- <el-aside   class="clooapse"  :width="isCollapse ?'105px':'250px'"> -->
      <!-- <div>
       </div> -->
      <!-- <div class="sidebar" :width="isCollapse ?'105px':'250px'">

          <el-menu  
          :unique-opened ="true"
            :collapse="isCollapse"
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            :collapse-transition="true"
            :show-timeout="500"
            :hide-timeout="500"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b"
          >
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>不知道写啥</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="1-2">选项2</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>但删掉又很怪</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="2-1">选项2</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="3">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>所以就先放着</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="3-1">选项2</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="4">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航一</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="4-1">选项2</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-submenu index="5">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航一</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="5-1">选项2</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </div> -->
      <!-- </el-aside> -->
      <el-main>
        <el-header>
          <div class="subject-right-header">
            <div class="subject-right-header-inside">
              <div class="subject-right-header-inside-line">
                <div class="subject-right-header-inside-line-left">
                  <el-link icon="el-icon-search">搜索</el-link>
                </div>
                <div class="subject-right-header-inside-line-right">
                  <el-input
                    placeholder="请输入内容"
                    v-model="search"
                    class="input-with-select"
                    size="mini"
                  >
                    <el-button
                      slot="append"
                      icon="el-icon-search"
                      @click="searchsubject"
                    ></el-button>
                  </el-input>
                </div>
              </div>
            </div>
          </div>
          <div class="subject-right-header">
            <div class="subject-right-header-inside">
              <div class="subject-right-header-inside-line">
                <div class="subject-right-header-inside-line-left">
                  <el-link icon="el-icon-search">筛选</el-link>
                </div>
                <div class="subject-right-header-inside-line-right">
                  <el-autocomplete
                    class="inline-input"
                    v-model="tag"
                    size="mini"
                    :fetch-suggestions="querySearch"
                    placeholder="请输入内容"
                    @select="handleSelect"
                  ></el-autocomplete>
                </div>
              </div>
            </div>
          </div>
          <div class="subject-right-header">
            <div class="subject-right-header-inside">
              <div class="subject-right-header-inside-line">
                <div class="subject-right-header-inside-line-left">
                  <el-link icon="el-icon-search">题型</el-link>
                </div>
                <div class="subject-right-header-inside-line-right">
                  <div>
                    <ul class="subject-right-header-inside-line-right-ul">
                      <li>简答</li>
                      <li>单选</li>
                      <li>不定项</li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="subject-right-header">
            <div class="subject-right-header-inside">
              <div class="subject-right-header-inside-line">
                <div class="subject-right-header-inside-line-left">
                  <el-link icon="el-icon-search">难度</el-link>
                </div>
                <div class="subject-right-header-inside-line-right">
                  <div>
                    <ul
                      class="subject-right-header-inside-line-right-ul"
                      id="nandu"
                    >
                      <li>简单</li>
                      <li>中等</li>
                      <li>困难</li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </el-header>
        <el-Footer class="footer-main-subject">
          <div class="footer-inside">
            <div class="footer-inside-information">
              <div class="transform">
                <div class="transform-inside">
                  <div class="transform-inside-information">
                    <div class="transform-inside-information-headera">
                      <div class="transform-inside-information-header-lefta">
                        <ul
                          class="transform-inside-information-header-left-ula"
                        >
                          <li value="1" class="active">最新</li>
                          <li value="2">最热</li>
                          <li value="3">收藏最多</li>
                          <!-- <li value="4">考试最多</li> -->
                        </ul>
                      </div>
                      <div class="transform-inside-information-header-right">
                        <ul
                          class="transform-inside-information-header-right-ula"
                        >
                          <li>
                            <el-button size="mini" @click="selected"
                              >精选</el-button
                            >
                          </li>
                        </ul>
                      </div>
                    </div>
                    <el-empty
                      description="搜索为空"
                      v-show="empty"
                      style="height: 446px"
                    ></el-empty>
                    <div class="tab-alla">
                      <div
                        class="tab-1"
                        style="display: block"
                        v-for="num in datalistall"
                        :key="num.id"
                      >
                        <div class="tab-1-inside">
                          <div class="tab-1-inside-information">
                            <div class="tab-1-inside-information-left">
                              <div
                                class="tab-1-inside-information-left-information"
                              >
                                <div
                                  class="tab-1-inside-information-left-information-one"
                                >
                                  <div
                                    v-html="num.titleName"
                                    @click="skip(num)"
                                  ></div>
                                </div>
                                <div
                                  class="tab-1-inside-information-left-information-two"
                                >
                                  <div>{{ num.tag }}</div>
                                  <!-- <div style="width:80px">javascript</div> -->
                                </div>
                                <div>
                                  <div
                                    class="tab-1-inside-information-left-information-three"
                                  >
                                    <div style="text-align: left">
                                      {{ num.questionType }}
                                    </div>
                                    <div class="center">
                                      {{ num.difficulty }}
                                    </div>
                                    <div style="text-align: right">
                                      {{ num.createTime }}
                                    </div>
                                  </div>
                                </div>
                                <div
                                  class="tab-1-inside-information-left-information-four"
                                >
                                  <div
                                    class="tab-1-inside-information-left-information-four-inside"
                                  >
                                    <el-link icon="el-icon-edit"
                                      >浏览:{{ num.pageViews }}</el-link
                                    >
                                    <el-link icon="el-icon-edit"
                                      >收藏:{{ num.collectionNumber }}</el-link
                                    >
                                    <el-link icon="el-icon-edit"
                                      >留言:{{ num.messageNumber }}</el-link
                                    >
                                  </div>
                                </div>
                              </div>
                            </div>
                            <div class="tab-1-inside-information-right">
                              <el-tooltip
                                effect="dark"
                                content="暂时没有想到能干啥"
                                placement="top"
                              >
                                <!-- <el-button type="primary" size="mini"
                                  >选题</el-button
                                > -->
                              </el-tooltip>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="tab-1">2</div>
                      <div class="tab-1">3</div>
                      <div class="tab-1">4</div>
                      <div class="fenye">
                        <el-pagination
                          background
                          @size-change="handleSizeChange"
                          @current-change="handleCurrentChange"
                          :current-page.sync="currentPage1"
                          :page-size="2"
                          layout="prev, pager, next"
                          :total="total"
                        >
                        </el-pagination>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </el-Footer>
      </el-main>
    </el-container>
    <!-- {{listdata.data}} -->
    <Floor></Floor>
  </div>
</template>

<script>
import Vue from "vue";
import "../css/subject.css";
// import floor from '../components/floor.vue';
// import Header from '../components/header.vue';

export default {
  data() {
    return {
      datalistall: "",
      btnvalue: "",
      a: {},
      total: null,
      currentPage1: 1,
      currentPage2: 5,
      currentPage3: 5,
      currentPage4: 4,
      isCollapse: false,
      input3: "",
      activeName: "second",
      radio: "1",
      searchsubjectvalue: "",
      listdata: null,
      listdatatwo: null,
      num: {},
      state1: "",
      textbtn: "简答题",
      thisval: {},
      empty: "",
      emptytwo: "",
      search: "",
      tag: "",
      difficulty: "",
      questionType: "",
      orderType: "",
    };
  },
  created() {
    this.searchsubject();
  },

  watch: {
    listdatatwo: function (now, old) {
      if (now == old)
        this.$http({
          methods: "get",
          url: "http://localhost:3001/users/all",
          params: {
            sha: this.listdatatwo,
          },
        }).then((res) => {
          this.listdata = res.data.data;
        });
    },
  },
  mounted() {
    let vm = this;
    this.$bus.$on("notmethod", this.demo);
    console.log(this.listdatatwo, "mount");

    let choosebtn = document
      .querySelector(".subject-right-header-inside-line-right-ul")
      .querySelectorAll("li");
    for (i = 0; i <= choosebtn.length - 1; i++) {
      choosebtn[i].onclick = function () {
        console.log(this.textContent);
        console.log(this.tag);
        Vue.prototype.$http
          .post(
            //请求的url
            "http://localhost:3001/title/query",
            //请求参数，不能以get请求方式写：{params: {userName: "root123", passWord: "root123"}}
            {
              search: this.search,
              tag: this.tag,
              questionType: this.textContent,
              difficulty: this.difficulty,
            },
            //解决跨域问题，不加无法跨域
            { emulateJSON: true }
          )
          .then(
            (res) => {
              console.log("2222", res.data);
              //    (this.datalistall = res.data.data), console.log(this.datalistall);
              Vue.prototype.$set(vm, "datalistall", res.data.data);
            },
            (res) => {
              console.log(res);
            }
          );
      };
    }

    // console.log(this)
    // let vm = this
    // let tagvalue
    let choosebtntwo = document.querySelector("#nandu").querySelectorAll("li");
    for (i = 0; i <= choosebtntwo.length - 1; i++) {
      choosebtntwo[i].onclick = function () {
        Vue.prototype.$http
          .post(
            //请求的url
            "http://localhost:3001/title/query",
            //请求参数，不能以get请求方式写：{params: {userName: "root123", passWord: "root123"}}
            {
              search: this.search,
              tag: this.tag,
              questionType: this.questionType,
              difficulty: this.textContent,
            },
            //解决跨域问题，不加无法跨域
            { emulateJSON: true }
          )
          .then(
            (res) => {
              Vue.prototype.$set(vm, "datalistall", res.data.data);
            },
            (res) => {
              console.log(res);
            }
          );
      };
    }

    this.restaurants = this.loadAll();
    var that = this;

    let li = document
      .querySelector(".transform-inside-information-header-left-ula")
      .querySelectorAll("li");
    let diva = document.querySelector(".tab-alla").querySelectorAll(".tab-1");
    var i;
    for (i = 0; i <= li.length - 1; i++) {
      li[i].onclick = function () {
        that.btnvalue = this.innerText;
        for (i = 0; i <= li.length - 1; i++) {
          li[i].className = "";
          this.className = "active";
        }
        for (var j = 0; j <= diva.length - 1; j++) {
          diva[j].className = "none";
          diva[j].setAttribute("index", j + 1);

          if (this.value == diva[j].getAttribute("index")) {
            diva[j].style.display = "block";

            var value = diva[j].getAttribute("index");
            this.orderType = value;
            Vue.prototype.$http
              .post(
                //请求的url
                "http://localhost:3001/title/query",
                //请求参数，不能以get请求方式写：{params: {userName: "root123", passWord: "root123"}}
                {
                  search: this.search,
                  tag: this.tag,
                  questionType: this.questionType,
                  difficulty: this.difficulty,
                  orderType: this.orderType,
                },
                //解决跨域问题，不加无法跨域
                { emulateJSON: true }
              )
              .then(
                (res) => {
                  console.log(res.data);
                  (this.datalistall = res.data.data),
                    console.log(this.datalistall);
                },
                (res) => {
                  console.log(res);
                }
              );
          } else {
            diva[j].style.display = "none";
          }
        }
      };
    }
  },

  methods: {
    skip(a) {
      console.log(a, this.$cookies.get("username"));
      this.$router.push("/contentmain?id=" + a.id);
    },
    selected() {
      this.$http({
        url: "http://localhost:3001/subject/selected",
        methods: "get",
      })
        .then((res) => {
          (this.listdata = res.data),
            (this.total = 4),
            (this.btnvalue = "精选");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    openclose() {
      this.isCollapse = !this.isCollapse;
    },
    demo(data) {
      // console.log(data,"事件总线")
      // var a = this.listdata
      this.listdatatwo = data;
      console.log(this.listdatatwo, "事件总线");
      // console.log(this.listdata,"mthod")
    },

    abs() {},
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.$http({
        methods: "get",
        url: "http://localhost:3001/users/fenyeall",
        params: {
          num: `${val}`,
          btnvalue: this.btnvalue,
        },
      })
        .then((res) => {
          console.log(res), (this.listdata = res.data);

          // this.total = res.data.length
          // this.total = 4
        })
        .catch((err) => {
          console.log(err);
        });
    },

    loadAll() {
      return [
        { value: "Java" },
        { value: "python" },
        { value: "前端" },
        { value: "golang" },
        { value: "c++ss" },
      ];
    },
    shaixuan() {},
    handleSelect(item) {
      console.log(item);
      this.searchsubject();
    },
    querySearch(queryString, cb) {
      var restaurants = this.restaurants;
      // var results = queryString
      //   ? restaurants.filter(queryString)
      //   : restaurants;
      // 调用 callback 返回建议列表的数据
      cb(restaurants);
    },
    searchsubject() {
      this.$http
        .post(
          //请求的url
          "http://localhost:3001/title/query",
          //请求参数，不能以get请求方式写：{params: {userName: "root123", passWord: "root123"}}
          {
            search: this.search,
            tag: this.tag,
            questionType: this.questionType,
            difficulty: this.difficulty,
            orderType: this.orderType,
          },
          //解决跨域问题，不加无法跨域
          { emulateJSON: true }
        )
        .then(
          (res) => {
            console.log(res.data);
            (this.datalistall = res.data.data), console.log(this.datalistall);
          },
          (res) => {
            console.log(res);
          }
        );
    },
    throwall(value) {
      console.log(value);
      this.$http({
        methods: "get",
        url: "http://localhost:3001/users/search",
        params: {
          searcha: value,
        },
      })
        .then((res) => {
          console.log(res);
          (this.listdata = res.data), console.log(this.listdata);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClick(tab, event) {
      console.log(tab, event);
    },
  },

  computed: {},
};
</script>

<style lang="css" scoped>
.el-header {
  background: white;
  height: 270px !important;
  margin-bottom: 30px;
  display: grid;
  align-items: center;
}
</style>