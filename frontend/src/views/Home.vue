<template>
  <div class="home">
    <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
    <div id="header" v-if="isAuthorized">
      <v-container fluid>
        <v-img src="@/assets/homeG.png" max-height="700px"></v-img>
      <!-- 로그인 후 화면 -->
        <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
          대기 화면
        </router-link>
        <router-link :to="{ name: 'Stock' }" class="nav-link" active-class="active" style="padding: 50px;">
          주식 정보 게시판
        </router-link>
        <button id="login" @click="onClickLogout">Logout</button>
      </v-container>
      <div>
        <br><span>{{ myinfo.auth }}님 접속을 환영합니다.</span>
      </div>
    </div>
    <!-- 로그인 전 화면  -->
    <div id="header" v-else>
      <v-container fluid>
        <v-img src="@/assets/C.png" max-height="400px"></v-img>
      <button id="login" @click="$router.push('AdminSetupPage')">
        회원가입
      </button><br><br>
      <button id="login" @click="$router.push('LoginPage')">
        로그인
      </button>
      <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
        대기 화면
      </router-link><br>
      <router-link :to="{ name: 'About' }" class="nav-link" active-class="active">
        About Us
      </router-link>
      </v-container>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
// import cookies from 'vue-cookies'

import { mapState, mapGetters, mapActions } from 'vuex'

// Vue.use(cookies)

export default {
  name: 'Home',
  data: function () {
    return {
      message: 'Vue Test Message'
    }
  },
  methods: {
    onClickLogout () {
      this.logout()
      alert('Success Logout')
      this.$router.push({ name: 'Home' })
    },
    ...mapActions(['logout'])
  },
  computed: {
    ...mapState(['myinfo']),
    ...mapGetters(['isAuthorized'])
  },
  components: {
  }
}
</script>

<style scoped>
div {
  border: 1px solid #ccc;
}

#header {
  //padding: 15px;
  //margin-bottom: 15px;
  //margin: 5px 5px;
}

img {
  width: auto;
  height: auto;
  max-width: 1000px;
  max-height: 350px;
  display: block;
  margin-left: auto;
  margin-right: auto;
}

#login {
  background-color: #77aadd;
  color: #ffffff;
  font-weight: bold;
  float: right;
}

</style>
