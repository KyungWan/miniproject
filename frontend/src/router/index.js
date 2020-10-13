import Vue from 'vue'
import VueRouter from 'vue-router'

import Home from '../views/Home.vue'

import analysis from '../views/analysis.vue'
import recommendation from '../views/recommendation.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/analysis',
    name: 'analysis',
    component: analysis
  },
  {
    path: '/recommendation',
    name: 'recommendation',
    component: recommendation
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
