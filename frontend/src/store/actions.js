import {
  SET_ACCESS_TOKEN,
  SET_MY_INFO,
  /* eslint-disable no-unused-vars */
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO,
  /* Crawl */
  FINDONE,
  FINDHOME,
  CRAWLSTART
} from './mutation-types'

import axios from 'axios'
import router from '../router'

export default {
  async crawlFind ({ commit }, category) {
    axios.get('http://localhost:7777/' + `${category}`)
      .then(({ data }) => {
        commit('CRAWLSTART', data)
        if (window.location.pathname !== '/Stock') {
          router.push('/Stock')
        }
      })
  },
  async crawlFindOne ({ commit }, newsNo) {
    axios.get('http://localhost:7777/news/' + `${newsNo}`)
      .then(({ data }) => {
        console.log('/news/newsNo res: ' + data)
        commit('FINDONE', data)
        router.push('/Stock/news')
      })
  },
  save ({ state }) {
    const data = {
      todoItems: state.todoItems,
      nextTodoId: state.nextTodoId
    }
    localStorage.setItem('todo-app-data', JSON.stringify(data))
  },
  login ({ commit }, payload) {
    console.log('actions login')
    return axios.post(`http://localhost:7777/api/authenticate?username=${payload.userid}&password=${payload.password}`, {
      username: payload.userid,
      password: payload.password
    }).then(res => {
      console.log('actions after post')
      const { authorization } = res.headers
      const accessToken = authorization.substring(7)

      commit(SET_ACCESS_TOKEN, accessToken)

      return axios.get('http://localhost:7777/users/myinfo')
    }).then(res => {
      console.log('After Get Auth Info')
      commit(SET_MY_INFO, res.data)
    })
  },
  loginByToken ({ commit }, token) {
    commit(SET_ACCESS_TOKEN, token)
    return axios.get('http://localhost:7777/users/myinfo')
      .then(res => {
        commit(SET_MY_INFO, res.data)
      })
  },
  logout ({ commit }) {
    commit(DESTROY_MY_INFO)
    commit(DESTROY_ACCESS_TOKEN)
  }
}
// actions: {
//  generateRandomNumber ({ commit }) {
//    console.log(commit)
//
//    axios.get('http://localhost:7777/random')
//      .then((res) => {
//        commit('successGenRandNum',
//          parseInt(res.data.randNumber))
//      })
//      .catch((res) => {
//        commit('failGenRandNum', res)
//      })
//  },
//  addTodo (context, payload) {
//    context.commit('ADD_TODO', payload)
//  },
//  removeTodo (context, payload) {
//    context.commit('REMOVE_TODO', payload)
//  },
//  clearAll (context, payload) {
//    context.commit('CLEAR_ALL')
//  }
