<template>
  <div>
    <!-- blob:http://localhost:8081/cde0ef9c-50dc-4183-b359-03095bd70001 -->
    <div class="person-main-inside">
      <!-- <div class="person-main-inside-top" > -->
        <!-- <div class="person-main-inside-top-information"> -->
          <!-- <div class="person-main-inside-top-information-img"> -->
          <!-- <img :src="require(`../assets/img/${userdata.img}`)"> -->
          <!-- <img :src="absa" alt=""> -->
          <!-- <img :src="require(`../assets/img/${absa}`)" alt=""> -->
          <!-- </div> -->
          <!-- <div class="person-main-inside-top-information-synopsis"> -->
            <!-- <div class="person-main-inside-top-information-synopsis-header"> -->
              <!-- <div>{{userdataold.username}}</div> -->
              <!-- <div>
                <el-tag type="">{{userdata.tag}}</el-tag>
              </div> -->
            <!-- </div> -->
            <!-- <div class="person-main-inside-top-information-synopsis-botton">
              <div>我自己忘了这里是什么了</div>
            </div> -->
          <!-- </div> -->
        <!-- </div> -->
      <!-- </div> -->
      <div class="person-main-inside-botton">
        <div class="person-main-inside-botton-information">
          <div class="person-main-inside-botton-information-header">
            <div class="person-main-inside-botton-information-header-inside">
              <div>信息</div>
              <div>
                <!-- <template slot-scope="scope"> -->
                <el-button type="text" @click="abs"
                  >编辑</el-button
                >
                <el-dialog title="修改信息" :visible.sync="dialogFormVisible">
                  <el-form :model="form" >
                    <el-form-item
                      label="用户名"
                      :label-width="formLabelWidth"
                    >
                     <el-input
                        v-model="form.username"
                        autocomplete="off"
                      ></el-input>
                    </el-form-item>
                    <el-form-item
                      label="性别"
                      :label-width="formLabelWidth"
                    >
                      
                      <el-select v-model="value" placeholder="请选择">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
                    </el-form-item>
                    <el-form-item
                      label="头像"
                      :label-width="formLabelWidth"
                    >
                       <!-- <el-input
                        v-model="form.img"
                        autocomplete="off"
                      ></el-input> -->
                      <!-- action="filenew" -->
                      <el-upload
  class="avatar-uploader"
  
   action="http://localhost:3001/users/pictureUpload"
  :show-file-list="false"
  :on-success="handleAvatarSuccess"
  :before-upload="beforeAvatarUpload"
  :data="{ module: 'headUrl' }">
  <img v-if="imageUrl" :src="imageUrl" class="avatar">
  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
</el-upload>
                    </el-form-item>
                    <el-form-item
                      label="注册时间"
                      :label-width="formLabelWidth"
                    >
                       <el-input
                       disabled
                        v-model="form.createTime"
                        autocomplete="off"
                      ></el-input>
                    </el-form-item>
                    <el-form-item
                      label="邮箱"
                      :label-width="formLabelWidth"
                    >
                       <el-input
                        v-model="form.email"
                        autocomplete="off"
                      ></el-input>
                    </el-form-item>

                    <el-form-item
                      label="兴趣"
                      :label-width="formLabelWidth"
                    >
                       <el-input
                        v-model="form.interest"
                        autocomplete="off"
                      ></el-input>
                    </el-form-item>
                    <el-form-item
                      label="介绍"
                      :label-width="formLabelWidth"
                    >
                       <el-input
                        v-model="form.introduction"
                        autocomplete="off"
                      ></el-input>
                    </el-form-item>
                  </el-form>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible = false"
                      >取 消</el-button
                    >
                    <el-button type="primary" @click="verifybutton()"
                      >确 定</el-button
                    >
                  </div>
                </el-dialog>
                 <!-- </template> -->
              </div>
             
            </div>
            
          </div>
          <div class="person-main-inside-botton-information-describe">
            <!-- <div class="person-main-inside-botton-information-describe-inside"> -->
              <div
                class="
                  person-main-inside-botton-information-describe-inside-col
                " 
              >
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-left
                  "
                >
                  用户名
                </div>
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-right
                  "
                >
                  {{userdataold.username}}
                </div>
              </div>
              <div
                class="
                  person-main-inside-botton-information-describe-inside-col
                "
              >
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-left
                  "
                >
                  性别
                </div>
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-right
                  "
                >
                  {{userdataold.sex}}
                </div>
              </div>
              <div
                class="
                  person-main-inside-botton-information-describe-inside-col
                "
              >
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-left
                  "
                >
                  简介
                </div>
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-right
                  "
                >
                   {{userdataold.introduction}}
                </div>
              </div>
              <div
                class="
                  person-main-inside-botton-information-describe-inside-col
                "
              >
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-left
                  "
                >
                  兴趣
                </div>
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-right
                  "
                >
                  {{userdataold.interest}}
                </div>
              </div>

              <div
                class="
                  person-main-inside-botton-information-describe-inside-col
                "
              >
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-left
                  "
                >
                  邮箱
                </div>
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-right
                  "
                >
                   {{userdataold.email}}
                </div>
              </div>
              <div
                class="
                  person-main-inside-botton-information-describe-inside-col
                "
              >
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-left
                  "
                >
                  注册时间
                </div>
                <div
                  class="
                    person-main-inside-botton-information-describe-inside-col-right
                  "
                >
                  {{userdataold.createTime}}
                </div>
              </div>
            <!-- </div> -->
          </div>
        </div>
      </div>
    </div>
    <floor></floor>
  </div>
</template>

<script>
import "../css/childdata.css"
export default {
  name: "WorkspaceJsonChilddata",

  data() {
    return {
       options: [
        {
          value: '男',
          label: '男'
        },
         {
          value: '女',
          label: '女'
        }
        ],
        value: '',
       imageUrl: '',
        absa:"",
        // a:"../assets/img/qq.jpg",
        //  img:('../assets/img/qq.jpg'),
        //  imga:require(this.a),
        userdata:"",
        userdataold:"",
      formLabelWidth: "120px",
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        id:"",
        // img:"qq.jpg",
        username:"",
        score:"",
        sex:"",
        introduction:"",
        interest:"",
        state:"",
        email:"",
        createTime:"",
        img:"",
        tag:"",
        headUrl:"",
      },
    };
  },

  mounted() {
    var times = Date(Date.now())
     console.log(times.toString() )
    // console.log(img)
    //  this.$http({
    //       // url:"http://localhost:3001/toux",
    //       url:"http://localhost:3001/users/toux",
    //       // url:"http://localhost:3001/toux",
    //       method:"get",
    //     }).then((res) => {
    //       console.log(res),this.absa = res.data[0].img,window.sessionStorage.setItem("img",res.data[0].img)
    //     }).catch((err) => {
    //       console.log(err)          
    //     });

  this.getBaseInfo();
  },

  methods: {
    getBaseInfo(){
      this.$http({
        methods:"get",
        
        url:"http://localhost:3001/users/searchuser",
        params:{
          username:this.$cookies.get("username")
        }
        
    }).then(res=>{
        console.log("1111",res.data.data)
        this.userdataold=res.data.data

    }).catch(err=>{
        console.log(err)
    })
    },
     handleAvatarSuccess(response, file) {
       console.log("response",response,file)
       this.imageUrl= response.data
       this.form.headUrl=response.data
       console.log("value",this.value);
       this.form.sex= this.value
      //   // this.imageUrl = URL.createObjectURL(file.raw);
      //   this.$http({
      //     url:"http://localhost:3001/users/updateimg",
      //     // url:"http://localhost:3001/updateimg",
      //     method:"get",
      //   }).then((res) => {
      //     console.log(res),this.imageUrl = res.data[0].img,location.reload()
      //   }).catch((err) => {
      //     console.log(err)          
      //   });
      // this.form.headu
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },
    verifybutton(){
      this.dialogFormVisible = false,
     
      // console.log(11)
      this.$http.post(
            //请求的url
            "http://localhost:3001/users/update",
            //请求参数，不能以get请求方式写：{params: {userName: "root123", passWord: "root123"}}
            this.form ,
            //解决跨域问题，不加无法跨域
            {emulateJSON: true}
        ).then(
             (res)=> {
              console.log("2222",res.data.data);
              this.form= res.data.data
           //   this.$router.push('/childdata')
              
                this.getBaseInfo()
            //    this.msg = res.bodyText;
            },
             (res)=> {
                console.log(res);
            }
        );
    },
    abs(){
        this.dialogFormVisible = true
       let username= this.$cookies.get("username")
       

       this.$http({
          url:"http://localhost:3001/users/baseInfo",
          //  url:"http://localhost:3001/update",
          methods:"get",
          params:{
            username:username
          }
        }).then(res=>{
          console.log("12222",res.data.data)
          this.form=res.data.data
          this.value=res.data.data.sex
          console.log(this.form)
        })

        console.log(this.dialogFormVisible)
       
    }
  },
};
</script>

<style lang="css" scoped>

</style>