import Vue from 'vue'
import Router from 'vue-router'
import Homepage from '../layout/Homepage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Homepage',
      // component: require('@/components/Homepage').default
      component: Homepage
    },
    {
      path: '*',
      redirect: '/'
    }
  ]
})
