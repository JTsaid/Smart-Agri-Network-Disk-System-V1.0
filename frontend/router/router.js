import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import gerenwangpanList from '../pages/gerenwangpan/list'
import gerenwangpanDetail from '../pages/gerenwangpan/detail'
import gerenwangpanAdd from '../pages/gerenwangpan/add'
import ziyuanfenxiangList from '../pages/ziyuanfenxiang/list'
import ziyuanfenxiangDetail from '../pages/ziyuanfenxiang/detail'
import ziyuanfenxiangAdd from '../pages/ziyuanfenxiang/add'
import haoyouliebiaoList from '../pages/haoyouliebiao/list'
import haoyouliebiaoDetail from '../pages/haoyouliebiao/detail'
import haoyouliebiaoAdd from '../pages/haoyouliebiao/add'
import haoyouliaotianList from '../pages/haoyouliaotian/list'
import haoyouliaotianDetail from '../pages/haoyouliaotian/detail'
import haoyouliaotianAdd from '../pages/haoyouliaotian/add'
import huifuliaotianList from '../pages/huifuliaotian/list'
import huifuliaotianDetail from '../pages/huifuliaotian/detail'
import huifuliaotianAdd from '../pages/huifuliaotian/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'gerenwangpan',
					component: gerenwangpanList
				},
				{
					path: 'gerenwangpanDetail',
					component: gerenwangpanDetail
				},
				{
					path: 'gerenwangpanAdd',
					component: gerenwangpanAdd
				},
				{
					path: 'ziyuanfenxiang',
					component: ziyuanfenxiangList
				},
				{
					path: 'ziyuanfenxiangDetail',
					component: ziyuanfenxiangDetail
				},
				{
					path: 'ziyuanfenxiangAdd',
					component: ziyuanfenxiangAdd
				},
				{
					path: 'haoyouliebiao',
					component: haoyouliebiaoList
				},
				{
					path: 'haoyouliebiaoDetail',
					component: haoyouliebiaoDetail
				},
				{
					path: 'haoyouliebiaoAdd',
					component: haoyouliebiaoAdd
				},
				{
					path: 'haoyouliaotian',
					component: haoyouliaotianList
				},
				{
					path: 'haoyouliaotianDetail',
					component: haoyouliaotianDetail
				},
				{
					path: 'haoyouliaotianAdd',
					component: haoyouliaotianAdd
				},
				{
					path: 'huifuliaotian',
					component: huifuliaotianList
				},
				{
					path: 'huifuliaotianDetail',
					component: huifuliaotianDetail
				},
				{
					path: 'huifuliaotianAdd',
					component: huifuliaotianAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
