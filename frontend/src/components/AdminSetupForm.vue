<template>
  <div class="SignUp">
    <form @submit.prevent="submit">
      <!-- 회원 가입   Sign Up-->
      <input type="text" placeholder="userId" v-model="userId"><br>
      <input type="password" placeholder="userPw" v-model="userPw"><br>
      <input type="text" placeholder="userName" v-model="userName"><br>

      <!-- 회원 가입 등록 버튼 -->
      <button type="submit"><p style="border-style: groove">등록</p></button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'AdminSetupForm',
  data () {
    return {
      userId: '',
      userName: '',
      userPw: ''
    }
  },
  methods: {
    submit () {
      console.log('this: ' + this.userId + ', ' + this.userName + ', ' + this.userPw)
      const { userId, userName, userPw } = this
      this.$emit('submit', { userId, userName, userPw })
    }
  }
}
</script>

<style scoped>
  .SignUp {
    margin-top: 10px;
  }
  input {
    margin: 10px 0;
    width: 30%;
    padding: 15px;
  }
  button {
    margin-top: 20px;
    width: 10%;
    cursor: pointer;
  }
  .border-styles > p{
    margin: 2px 0;
    padding: 1px 3px;
    border-width: 2px;
    border-color: #aaa;
  }
</style>
