<template>
  <form @submit.prevent="submit">
    <table>
    <!-- 회원 가입 -->
      <tr>
        <td>User ID : </td>
        <td><input type="text" v-model="userId"></td>
      </tr>
      <tr>
        <td>Password : </td>
        <td><input type="password" v-model="userPw"></td>
      </tr>
      <tr>
        <td>Nick Name : </td>
        <td><input type="text" v-model="userName"></td>
      </tr>
    </table>

    <!-- 회원 가입 등록 버튼 -->
    <div>
      <button type="submit">등록</button>
    </div>
  </form>
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
