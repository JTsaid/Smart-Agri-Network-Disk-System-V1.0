<template>
<div :style='{"width":"1200px","padding":"120px 7% 100px","margin":"0px auto","position":"relative","background":"url(http://codegen.caihongy.cn/20230109/138a4d606eae4a168810cef229969885.png) no-repeat center top,url(http://codegen.caihongy.cn/20230109/b95aeae1c1294f398aefb7c6cd5b16de.png) no-repeat center top,url(http://codegen.caihongy.cn/20230109/5ffc803e6682418eb7f0b09a98e35527.png) no-repeat center bottom,#faf0e6"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="150px"
    >
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="用户账号" prop="yonghuzhanghao">
            <el-input v-model="ruleForm.yonghuzhanghao" 
                placeholder="用户账号" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="用户姓名" prop="yonghuxingming">
            <el-input v-model="ruleForm.yonghuxingming" 
                placeholder="用户姓名" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="分享名称" prop="fenxiangmingcheng">
            <el-input v-model="ruleForm.fenxiangmingcheng" 
                placeholder="分享名称" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}'  label="分享分类" prop="fenxiangfenlei">
            <el-select v-model="ruleForm.fenxiangfenlei" placeholder="请选择分享分类"  >
              <el-option
                  v-for="(item,index) in fenxiangfenleiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="二维码" v-if="type!='cross' || (type=='cross' && !ro.erweima)" prop="erweima">
            <file-upload
            tip="点击上传二维码"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.erweima?ruleForm.erweima:''"
            @change="erweimaUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' class="upload" v-else label="二维码" prop="erweima">
                <img v-if="ruleForm.erweima.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.erweima.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.erweima.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="文档" prop="wendang">
            <file-upload
            tip="点击上传文档"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.wendang?ruleForm.wendang:''"
            @change="wendangUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="视频" prop="shipin">
            <file-upload
            tip="点击上传视频"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.shipin?ruleForm.shipin:''"
            @change="shipinUploadChange"
            ></file-upload>
          </el-form-item> 
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="音频" prop="yinpin">
            <file-upload
            tip="点击上传音频"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.yinpin?ruleForm.yinpin:''"
            @change="yinpinUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="其他文件" prop="qitawenjian">
            <file-upload
            tip="点击上传其他文件"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.qitawenjian?ruleForm.qitawenjian:''"
            @change="qitawenjianUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="分享时间" prop="fenxiangshijian" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.fenxiangshijian" 
                  type="datetime"
                  placeholder="分享时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="图片" prop="tupian">
            <editor 
                :style='{"border":"1px solid #e5d9c6","minHeight":"300px","padding":"0","margin":"0","backgroundColor":"#fff","borderRadius":"0","width":"100%","height":"auto"}'
                v-model="ruleForm.tupian" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","boxShadow":"0 2px 0 #efe4d4","margin":"0 0 10px"}' label="分享详情" prop="fenxiangxiangqing">
            <editor 
                :style='{"border":"1px solid #e5d9c6","minHeight":"300px","padding":"0","margin":"0","backgroundColor":"#fff","borderRadius":"0","width":"100%","height":"auto"}'
                v-model="ruleForm.fenxiangxiangqing" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","textAlign":"center","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"#cca162","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#009688","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
        ro:{
            yonghuzhanghao : false,
            yonghuxingming : false,
            fenxiangmingcheng : false,
            fenxiangfenlei : false,
            erweima : false,
            wendang : false,
            shipin : false,
            yinpin : false,
            qitawenjian : false,
            tupian : false,
            fenxiangshijian : false,
            fenxiangxiangqing : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          yonghuzhanghao: '',
          yonghuxingming: '',
          fenxiangmingcheng: '',
          fenxiangfenlei: '',
          erweima: '',
          wendang: '',
          shipin: '',
          yinpin: '',
          qitawenjian: '',
          tupian: '',
          fenxiangshijian: '',
          fenxiangxiangqing: '',
        },
        fenxiangfenleiOptions: [],


        rules: {
          yonghuzhanghao: [
          ],
          yonghuxingming: [
          ],
          fenxiangmingcheng: [
          ],
          fenxiangfenlei: [
          ],
          erweima: [
          ],
          wendang: [
          ],
          shipin: [
          ],
          yinpin: [
          ],
          qitawenjian: [
          ],
          tupian: [
          ],
          fenxiangshijian: [
          ],
          fenxiangxiangqing: [
          ],
        },
      };
    },
    computed: {



    },
    components: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.fenxiangshijian = this.getCurDateTime()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='yonghuzhanghao'){
              this.ruleForm.yonghuzhanghao = obj[o];
              this.ro.yonghuzhanghao = true;
              continue;
            }
            if(o=='yonghuxingming'){
              this.ruleForm.yonghuxingming = obj[o];
              this.ro.yonghuxingming = true;
              continue;
            }
            if(o=='fenxiangmingcheng'){
              this.ruleForm.fenxiangmingcheng = obj[o];
              this.ro.fenxiangmingcheng = true;
              continue;
            }
            if(o=='fenxiangfenlei'){
              this.ruleForm.fenxiangfenlei = obj[o];
              this.ro.fenxiangfenlei = true;
              continue;
            }
            if(o=='erweima'){
              this.ruleForm.erweima = obj[o].split(",")[0];
              this.ro.erweima = true;
              continue;
            }
            if(o=='wendang'){
              this.ruleForm.wendang = obj[o];
              this.ro.wendang = true;
              continue;
            }
            if(o=='shipin'){
              this.ruleForm.shipin = obj[o];
              this.ro.shipin = true;
              continue;
            }
            if(o=='yinpin'){
              this.ruleForm.yinpin = obj[o];
              this.ro.yinpin = true;
              continue;
            }
            if(o=='qitawenjian'){
              this.ruleForm.qitawenjian = obj[o];
              this.ro.qitawenjian = true;
              continue;
            }
            if(o=='tupian'){
              this.ruleForm.tupian = obj[o];
              this.ro.tupian = true;
              continue;
            }
            if(o=='fenxiangshijian'){
              this.ruleForm.fenxiangshijian = obj[o];
              this.ro.fenxiangshijian = true;
              continue;
            }
            if(o=='fenxiangxiangqing'){
              this.ruleForm.fenxiangxiangqing = obj[o];
              this.ro.fenxiangxiangqing = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0){
                this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
            }
            if((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0){
                this.ruleForm.yonghuxingming = json.yonghuxingming
            }
          }
        });
        this.fenxiangfenleiOptions = "图片,文档,视频,音频,其他文件".split(',')
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('ziyuanfenxiang/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('ziyuanfenxiang/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('ziyuanfenxiang/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('ziyuanfenxiang/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
                      }
                  });
             }
          }
        });
      },
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
      // 返回
      back() {
        this.$router.go(-1);
      },
      erweimaUploadChange(fileUrls) {
          this.ruleForm.erweima = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
      wendangUploadChange(fileUrls) {
          this.ruleForm.wendang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
      shipinUploadChange(fileUrls) {
          this.ruleForm.shipin = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
      yinpinUploadChange(fileUrls) {
          this.ruleForm.yinpin = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
      qitawenjianUploadChange(fileUrls) {
          this.ruleForm.qitawenjian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 150px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #e5d9c6;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #e5d9c6;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #e5d9c6;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  border: 1px solid #e5d9c6;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #e5d9c6;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #e5d9c6;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #333;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #e5d9c6;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
