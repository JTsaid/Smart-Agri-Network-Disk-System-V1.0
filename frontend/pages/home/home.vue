<template>
<div class="home-preview" :style='{"width":"100%","margin":"0px auto","flexWrap":"wrap","justifyContent":"center","display":"flex"}'>






<div class="lists" :style='{"width":"100%","margin":"0px auto","position":"relative","background":"#faf0e6"}'>
	
	<div class="title" :style='{"width":"100%","padding":"0px 7%","margin":"0px auto 0px","lineHeight":"54px","textAlign":"left","background":"none"}'>
	  <span :style='{"margin":"0 4px 0 0","fontSize":"20px","lineHeight":"24px","color":"#202020","fontWeight":"bold"}'>资源分享展示</span>
	</div>
	
	<div v-if="true" class="idea" :style='{"width":"100%","padding":"0px 7%","flexWrap":"wrap","background":"#faf0e6","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"100%","background":"url(http://codegen.caihongy.cn/20230110/80e36442864b4158aae8264689c04a4d.jpg) no-repeat center center / 100% 100%","height":"280px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	
	
	
	
	
	
	<!-- 样式七 -->
	<div class="list list7 index-pv1" :style='{"padding":"20px 7% 40px","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
		<div v-if="ziyuanfenxiangList.length>0" class="list-4-item animation-box item-1" @click="toDetail('ziyuanfenxiangDetail', ziyuanfenxiangList[0])" :style='{"width":"24%","margin":"0 0px","overflow":"hidden","position":"relative","height":"570px"}'>
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(ziyuanfenxiangList[0].erweima)" :src="ziyuanfenxiangList[0].erweima.split(',')[0]" alt="" />
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (ziyuanfenxiangList[0].erweima?ziyuanfenxiangList[0].erweima.split(',')[0]:'')" alt="" />
			<div class="list-4-item-title line1" :style='{"overflow":"hidden","color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"16px","position":"absolute"}'>
                <div>{{ziyuanfenxiangList[0].fenxiangmingcheng}}</div>
                <div>{{ziyuanfenxiangList[0].fenxiangfenlei}}</div>
            </div>
		</div>
		<div :style='{"width":"24%","margin":"0 0px","height":"275px"}' class="list-4-body">
			<div v-if="ziyuanfenxiangList.length>1" @click="toDetail('ziyuanfenxiangDetail', ziyuanfenxiangList[1])" class="list-4-item animation-box item-2" :style='{"width":"100%","margin":"0 0 20px","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","overflow":"hidden","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(ziyuanfenxiangList[1].erweima)" :src="ziyuanfenxiangList[1].erweima.split(',')[0]" alt="" />
				<img :style='{"width":"100%","overflow":"hidden","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (ziyuanfenxiangList[1].erweima?ziyuanfenxiangList[1].erweima.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"16px","position":"absolute"}'>
                    <div>{{ziyuanfenxiangList[1].fenxiangmingcheng}}</div>
                    <div>{{ziyuanfenxiangList[1].fenxiangfenlei}}</div>
                </div>
			</div>
			<div v-if="ziyuanfenxiangList.length>2" @click="toDetail('ziyuanfenxiangDetail', ziyuanfenxiangList[2])" class="list-4-item animation-box item-3" :style='{"width":"100%","margin":"20px 0 0","overflow":"hidden","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(ziyuanfenxiangList[2].erweima)" :src="ziyuanfenxiangList[2].erweima.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (ziyuanfenxiangList[2].erweima?ziyuanfenxiangList[2].erweima.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"16px","position":"absolute"}'>
                    <div>{{ziyuanfenxiangList[2].fenxiangmingcheng}}</div>
                    <div>{{ziyuanfenxiangList[2].fenxiangfenlei}}</div>
                </div>
			</div>
		</div>
		<div v-if="ziyuanfenxiangList.length>3" class="list-4-item animation-box item-1" @click="toDetail('ziyuanfenxiangDetail', ziyuanfenxiangList[3])" :style='{"width":"24%","margin":"0 0px","overflow":"hidden","position":"relative","height":"570px"}'>
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(ziyuanfenxiangList[3].erweima)" :src="ziyuanfenxiangList[3].erweima.split(',')[0]" alt="" />
			<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (ziyuanfenxiangList[3].erweima?ziyuanfenxiangList[3].erweima.split(',')[0]:'')" alt="" />
			<div class="list-4-item-title line1" :style='{"color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"16px","position":"absolute"}'>
                <div>{{ziyuanfenxiangList[3].fenxiangmingcheng}}</div>
                <div>{{ziyuanfenxiangList[3].fenxiangfenlei}}</div>
            </div>
		</div>
		<div :style='{"width":"24%","margin":"0 10px","height":"275px"}' class="list-4-body">
			<div v-if="ziyuanfenxiangList.length>4" @click="toDetail('ziyuanfenxiangDetail', ziyuanfenxiangList[4])" class="list-4-item animation-box item-4" :style='{"width":"100%","margin":"0 0 20px","overflow":"hidden","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(ziyuanfenxiangList[4].erweima)" :src="ziyuanfenxiangList[4].erweima.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (ziyuanfenxiangList[4].erweima?ziyuanfenxiangList[4].erweima.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"16px","position":"absolute"}'>
                    <div>{{ziyuanfenxiangList[4].fenxiangmingcheng}}</div>
                    <div>{{ziyuanfenxiangList[4].fenxiangfenlei}}</div>
                </div>
			</div>
			<div v-if="ziyuanfenxiangList.length>5" @click="toDetail('ziyuanfenxiangDetail', ziyuanfenxiangList[5])" class="list-4-item animation-box item-5" :style='{"width":"100%","margin":"20px 0 0","overflow":"hidden","position":"relative","height":"100%"}'>
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-if="preHttp(ziyuanfenxiangList[5].erweima)" :src="ziyuanfenxiangList[5].erweima.split(',')[0]" alt="" />
				<img :style='{"width":"100%","objectFit":"cover","float":"left","height":"100%"}' v-else :src="baseUrl + (ziyuanfenxiangList[5].erweima?ziyuanfenxiangList[5].erweima.split(',')[0]:'')" alt="" />
				<div class="list-4-item-title line1" :style='{"color":"#fff","left":"0","textAlign":"center","bottom":"0","background":"rgba(0,0,0,.3)","width":"100%","lineHeight":"44px","fontSize":"16px","position":"absolute"}'>
                    <div>{{ziyuanfenxiangList[5].fenxiangmingcheng}}</div>
                    <div>{{ziyuanfenxiangList[5].fenxiangfenlei}}</div>
                </div>
			</div>
		</div>
	</div>
	
	
	
	<div @click="moreBtn('ziyuanfenxiang')" :style='{"border":"1px solid #999","padding":"0 16px","margin":"0px auto 0px","top":"0px","textAlign":"center","background":"none","display":"inline-block","width":"auto","lineHeight":"30px","position":"absolute","right":"7%"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#333","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	

</div>

	
<div class="news" :style='{"minHeight":"520px","padding":"100px 0 20px","margin":"0px auto 0px","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230109/5ffc803e6682418eb7f0b09a98e35527.png) no-repeat center top,#fff","display":"flex","width":"100%","position":"relative"}'>
	
	<div class="title" :style='{"width":"100%","padding":"0px 7%","margin":"0px auto 0px","lineHeight":"54px","textAlign":"left","background":"none"}'>
		<span :style='{"margin":"0 4px 0 0","fontSize":"20px","lineHeight":"24px","color":"#202020","fontWeight":"bold"}'>公告信息</span>
	</div>
	
	<div v-if="true" class="idea newsIdea" :style='{"width":"100%","padding":"0px 7%","flexWrap":"wrap","background":"#fff","justifyContent":"space-between","display":"flex"}'>
		<div class="box1" :style='{"width":"100%","background":"url(http://codegen.caihongy.cn/20230110/533c6403944f4524a04473dbecdf6668.jpg) no-repeat center center / 100% 100%","height":"280px"}'></div>
		<div class="box2" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box3" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box4" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box5" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box6" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box7" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box8" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box9" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
		<div class="box10" :style='{"width":"20%","background":"#fff","display":"none","height":"80px"}'></div>
	</div>
	
	
	
	
	
	
	
	
	
	
	<!-- 样式十 -->
	<div v-if="newsList.length" class="list list10 index-pv1" :style='{"padding":"40px 7% 40px","flexWrap":"wrap","background":"none","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
	  <div v-if="newsList.length>0" @click="toDetail('newsDetail', newsList[0])" :style='{"width":"48%","margin":"0 0px","position":"relative","background":"none","height":"auto"}' class="new10-list-item animation-box">
	    <img :style='{"border":"6px solid #cca162","width":"100%","objectFit":"cover","display":"block","height":"220px"}' :src="baseUrl + newsList[0].picture" alt="">
		<div :style='{"width":"calc(100% - 80px)","padding":"16px 0px 8px","fontSize":"20px","lineHeight":"28px","color":"#b58339"}' class="new9-list-item-title line1">{{newsList[0].title}}</div>
		<div :style='{"padding":"4px 8px","fontSize":"12px","lineHeight":"24px","color":"#fff","background":"#cca162","display":"inline-block"}' class="new9-list-item-time">{{newsList[0].addtime.split(' ')[0]}}</div>
	    <div :style='{"padding":"0 10px","overflow":"hidden","color":"#555","fontSize":"14px","lineHeight":"24px","textIndent":"2em","height":"72px"}' class="new9-list-item-descript line2">{{newsList[0].introduction}}</div>
		<div :style='{"padding":"0 10px","margin":"0 10px 10px","color":"#999","background":"#fff","display":"none","fontSize":"12px","lineHeight":"24px"}' class="new9-list-item-identification">新闻动态</div>
	  </div>
	  <div v-if="newsList.length>1" :style='{"padding":"0 0 0 120px","margin":"0 0px","background":"url(http://codegen.caihongy.cn/20230109/558d6ae97f424b9486bb076db9173c9b.png) no-repeat left top","flexDirection":"column","display":"block","width":"48%","position":"relative","justifyContent":"space-between","height":"400px"}'>
	    <div v-for="(item,index) in newsList" v-if="index<4 && index>0" :key="index" @click="toDetail('newsDetail', item)" :style='{"width":"100%","margin":"0 0 55px","position":"relative","background":"none","height":"100px"}' class="new10-list-item animation-box">
	        <div :style='{"padding":"0px","whiteSpace":"nowrap","overflow":"hidden","color":"#b58339","width":"calc(100% - 80px)","fontSize":"20px","lineHeight":"1","textOverflow":"ellipsis"}' class="new9-list-item-title line1">{{ item.title }}</div>
	        <div :style='{"fontSize":"12px","lineHeight":"1","position":"absolute","right":"20px","color":"#b89e66","top":"2px"}' class="new9-list-item-time">{{ item.addtime.split(' ')[0] }}</div>
			<div :style='{"padding":"0 0px","margin":"5px auto 0","overflow":"hidden","color":"#555","width":"calc(100% - 0px)","fontSize":"14px","lineHeight":"24px","textIndent":"2em","height":"72px"}' class="new9-list-item-descript line2">{{ item.introduction }}</div>
			<div :style='{"padding":"0 10px","fontSize":"12px","lineHeight":"24px","color":"#999","background":"#fff","display":"none"}' class="new9-list-item-identification">新闻动态</div>
	    </div>
	  </div>
	</div>
	
	<div @click="moreBtn('news')" :style='{"border":"1px solid #999","padding":"0 16px","margin":"0px auto 0px","top":"100px","textAlign":"center","background":"none","display":"inline-block","width":"auto","lineHeight":"30px","position":"absolute","right":"7%"}'>
		<span :style='{"color":"#333","fontSize":"14px"}'>查看更多</span>
		<i v-if="true" :style='{"color":"#333","fontSize":"14px"}' class="el-icon-d-arrow-right"></i>
	</div>
	
</div>

</div>
</template>

<script>
  export default {
    //数据集合
    data() {
      return {
        baseUrl: '',
        newsList: [],

        ziyuanfenxiangList: [],
      }
    },
    created() {
      this.baseUrl = this.$config.baseUrl;
      this.getNewsList();
      this.getList();
    },
    //方法集合
    methods: {
      preHttp(str) {
          return str && str.substr(0,4)=='http';
      },
		getNewsList() {
			this.$http.get('news/list', {params: {
				page: 1,
				limit: 4,
                sort: 'addtime',
			order: 'desc'}}).then(res => {
				if (res.data.code == 0) {
					this.newsList = res.data.data.list;
					
					
				}
			});
		},
		getList() {
          let autoSortUrl = "";
			
			this.$http.get('ziyuanfenxiang/list', {params: {
				sort : 'fenxiangshijian',
				order: 'desc',
				page: 1,
				limit: 6,
			}}).then(res => {
				if (res.data.code == 0) {
					this.ziyuanfenxiangList = res.data.data.list;
					
					// 商品列表样式五
					
				}
			});
		},
		toDetail(path, item) {
			this.$router.push({path: '/index/' + path, query: {detailObj: JSON.stringify(item)}});
		},
		moreBtn(path) {
			this.$router.push({path: '/index/' + path});
		}
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
	
		.recommend {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
        }
        
        .list5 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
		
		.news {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list6 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list6 .swiper-button-next {
				left: auto;
				right: 10px;
			}
			
			.list6 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: translate3d(0px,0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	
		.lists {
			.list3 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list3 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list3 .swiper-button-next {
				left: auto;
				right: 10px;
        }
        
        .list3 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-prev {
				left: 10px;
				right: auto;
			}
			
			.list5 .swiper-button-prev::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 .swiper-button-next {
            left: auto;
            right: 10px;
			}
			
			.list5 .swiper-button-next::after {
				color: rgb(64, 158, 255);
			}
			
			.list5 {
				.swiper-slide-prev {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-next {
					position: relative;
					z-index: 3;
				}
		
				.swiper-slide-active {
					position: relative;
					z-index: 5;
				}
			}
			
			.index-pv1 .animation-box {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				z-index: initial;
			}
			
			.index-pv1 .animation-box:hover {
				transform: translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			
			.index-pv1 .animation-box img {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			}
			
			.index-pv1 .animation-box img:hover {
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
		}
	}
</style>
