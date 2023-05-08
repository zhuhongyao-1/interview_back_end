<template>
    <div class="upload-subject">
      <Header></Header>
        <!-- <div style="border: 1px solid #ccc;" class="Toolbar">
                                    <Toolbar 
                                        style="border-bottom: 1px solid #ccc"
                                        :editorId="editorId"
                                        :defaultConfig="toolbarConfig"
                                        :mode="mode"
                                    />
                                    <Editor
                                        style="height: 300px; overflow-y: hidden;"
                                         :editorId="editorId"
                                        v-model="html"
                                        :defaultConfig="editorConfig"
                                        :mode="mode"
                                        @onCreated="onCreated"
                                    />
                                </div> -->
        <el-container>
            <el-main>
                <div class="prepare-upload">
                    <div class="prepare-upload-inside">
                       <div class="prepare-upload-inside-header">
                        <div class="prepare-upload-inside-header-container">
                          <div>上传题目</div>
                          <div>欢迎分享面试题，获取积分</div>
                        </div>
                       </div>
                       <div class="prepare-upload-inside-container">
                        <div class="prepare-uload-inside-container-inside">
                          <div class="prepare-uload-inside-container-inside-bushouyinxiang">
                            <div class="prepare-uload-inside-container-inside-bushouyinxiang-col">
                              <div class="subject-font"><span>*</span><span>题型</span></div>
                              <div class="selcetone" > 
                                <el-radio v-model="questionType" label="简答">简答</el-radio>
                                <el-radio v-model="questionType" label="单选">单选</el-radio>
                                <el-radio v-model="questionType" label="不定项">不定项</el-radio>
                                </div>
                            </div>
                          </div>
                           <div class="prepare-uload-inside-container-inside-bushouyinxiang">
                            <div class="prepare-uload-inside-container-inside-bushouyinxiang-col">
                              <div class="subject-font"><span>*</span><span>难度</span></div>
                              <div class="selcet"> 
                                <el-radio v-model="difficulty" label="简单">简单</el-radio>
                                <el-radio v-model="difficulty" label="中等">中等</el-radio>
                                <el-radio v-model="difficulty" label="困难">困难</el-radio>
                                </div>
                            </div>
                          </div>
                           <div class="prepare-uload-inside-container-inside-bushouyinxiang">
                            <div class="prepare-uload-inside-container-inside-bushouyinxiang-col">
                              <div class="subject-font"><span>*</span><span>标签</span></div>
                              <div class="selcet"> 
                                <el-select v-model="tag" placeholder="请选择">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
                                </div>
                            </div>
                          </div>
                           <div class="prepare-uload-inside-container-inside-bushouyinxiang">
                            <div class="prepare-uload-inside-container-inside-bushouyinxiang-col">
                              <div class="subject-font"><span>*</span><span>题目</span></div>
                            
                                 <div style="border: 1px solid #ccc;" class="Toolbar">
                                    <Toolbar 
                                        style="border-bottom: 1px solid #ccc"
                                        :editor="editor"
                                        :defaultConfig="toolbarConfig"
                                        :mode="mode"
                                    />
                                    <Editor
                                        style="height: 200px; overflow-y: hidden;"
                                        v-model="titleName"
                                        
                                        :defaultConfig="editorConfig"
                                        :mode="mode"
                                        @onCreated="onCreated"
                                    />
                                </div>
                                
                                
                            </div>
                          
                          </div>
                         <!-- <div id="toolbar-container"></div> -->
                        
                         <!-- <div ref='editor1'>11 </div> -->
                           <div class="prepare-uload-inside-container-inside-bushouyinxiang">
                            <div class="prepare-uload-inside-container-inside-bushouyinxiang-col">
                              <div class="subject-font"><span>*</span><span>参考解释</span></div>
                              <div class="selcet"> 
                                <quill-editor v-model="explains" :options="editorOption"/>
                                </div>
                            </div>
                          </div>
                           <!-- <div class="prepare-uload-inside-container-inside-bushouyinxiang">
                            <div class="prepare-uload-inside-container-inside-bushouyinxiang-col">
                              <div class="subject-font"><span>*</span><span>视频题解</span></div>
                              <div class="selcet"> 
                               <el-input v-model="input" placeholder="请输入内容"  size="small"></el-input>
                                </div>
                            </div>
                          </div> -->
                           <div class="prepare-uload-inside-container-inside-bushouyinxiang" style="margin-top: 70px;">
                            <div class="prepare-uload-inside-container-inside-bushouyinxiang-col">
                              <div class="subject-font"><span>*</span><span>备注</span></div>
                              <div class="selcet"> 
                                 <el-input v-model="remarks" placeholder="请输入内容"  size="small"></el-input>
                                </div>
                            </div>
                          </div>
                          <div class="Submit">
                            <div class="Submit-inside">
                              <el-button type="primary" @click="sumbit">提交</el-button>
                            </div>
                          </div>
                        </div>
                       </div>
                    </div>
                </div>
            </el-main>
            <el-aside>
              <div class="upload-inside">
                <div class="upload-iside-information">
                  <div class="upload-iside-information-inside">
                    <div class="upload-iside-information-header-border">
                  <div class="upload-iside-information-header">注意：相似题目（请勿重复上传）</div>
                  </div>
                  <div class="upload-iside-information-floor">输入题目后将自动检测：{{this.$store.state.username}}</div>
                  </div>
                </div>
              </div>
            </el-aside>
        </el-container>
        
    </div>
</template>

<script>
import "../css/upload.css"
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
import {quillEditor} from 'vue-quill-editor'
// import Vue from 'vue'
// import {  createToolbar } from '@wangeditor/editor'
import { Editor, Toolbar } from '@wangeditor/editor-for-vue'
export default {  
    name: 'WorkspaceJsonPersonsubject',
     components: { Editor, Toolbar,quillEditor },
    data() {
        return {
           areaoptions: [],
        areavalue: [],
        arealist: [],
        arealoading: false,
        states: ["广东","四川","浙江"],
          a:"",
          b:"",
             options: [{
          value: 'Java',
          label: 'Java'
        }, {
          value: 'C++',
          label: 'C++'
        }, {
          value: 'python',
          label: 'python'
        }, {
          value: 'c语言',
          label: 'c语言'
        }, 
        {
          value: '前端',
          label: '前端'
        },{
          value: '选项6',
          label: 'golang'
        }],
             tag: '',
             difficulty: '1',
             questionType:'',
             input: '',
              editor: null,
              // abs:null,
              // editorId:"editor",
              //  editorId2:"editor2",
            html: '',
            toolbarConfig: { },
            editorConfig: { placeholder: '请输入内容...' },
            mode: 'simple', // or 'simple'
            editorOption:{},
            goods:"",
            checkredio:'',
            explains:'',
            remarks:'',
            titleName:''
        };
    },
    watch:{
      checkredio:function(now,old){
        console.log(now,old)
        
        // if(this.checkredio ==)
        // // let checkredio
        //   let rediotag = document.querySelectorAll(".selcet")[0].children
        //   for(let tag = 0;tag<=rediotag.length-1;tag++){
        //     // console.log(rediotag[tag],"11")
        //     console.log(rediotag[tag],"11")
        //     if(rediotag[tag].className=='is-checked'){
        //       // console.log(1)
        //       this.checkredio = rediotag[tag].textContent
        //       console.log(this.checkredio)
        //     }else{
        //       console.log("出错")
        //     }
        //   } 
        //   console.log(rediotag)
      }
        
    },
    mounted() {
       this.arealist = this.states.map(item => {
        return { value: `${item}`, label: `${item}` };
      });
       console.log(this.questionType)
          setTimeout(() => {
            this.html = '<p></p>'
        }, 1500)
    },
  beforeDestroy() {
        const editor = this.editor
        if (editor == null) return
        editor.destroy() // 组件销毁时，及时销毁编辑器
    },
    methods: {
      remoteMethod(query) {
        if (query !== '') {
          this.arealoading = true;
          setTimeout(() => {
            this.arealoading = false;
            this.areaoptions = this.arealist.filter(item => {
              return item.label.toLowerCase()
                .indexOf(query.toLowerCase()) > -1;
            });
          }, 200);
        } else {
          this.areaoptions = [];
        }
      },
         onCreated(editor) {
            this.editor = Object.seal(editor) // 一定要用 Object.seal() ，否则会报错
           
        },
        sumbit(){ 
          console.log("titleName",this.titleName);
          console.log("explain",this.explains)
          console.log("remarks",this.remarks)
          console.log("userId",this.$cookies.get("userId"))

          this.$http.post(
            //请求的url
            "http://localhost:3001/title/save",
            //请求参数，不能以get请求方式写：{params: {userName: "root123", passWord: "root123"}}
            {"userId":this.$cookies.get("userId"),
            "questionType":this.questionType,
            "difficulty":this.difficulty,
            "tag":this.tag,
            "titleName":this.titleName,
            "explains":this.explains,
            "remarks":this.remarks,
          } ,
            //解决跨域问题，不加无法跨域
            {emulateJSON: true}
        ).then(
             (res)=> {
              console.log("2222",res.msg);
              this.$message({
                message: '添加成功',
                type: 'success'
        });
        this.questionType=''
        this.difficulty=''
        this.tag=''
        this.titleName=''
        this.explains=''
        this.remarks=''
            },
             (res)=> {
                console.log(res);
            }
        );
        },
        q(){
          console.log(1111111)
        }
    },
};
</script>
<style src="@wangeditor/editor/dist/css/style.css"></style>
<style lang="css" scoped>


</style>

