<template>
  <div class="login">
    <form @submit.prevent="submit">
      <input type="text" placeholder="Id" v-model="userid"><br>
      <input type="password" placeholder="password" v-model="password"><br>
      <button><p style="border-style: groove">Login</p></button>
    </form>
  </div>
</template>

  <!--  <div class="login">
  <input type="text" placeholder="Id"><br>
  <input type="password" placeholder="password"><br>
  <button>Login</button>
  </div> -->

<script>
export default {
  name: 'LoginForm',
  data () {
    return {
      userid: '',
      password: ''
    }
  },
  methods: {
    submit () {
      console.log('LoginForm submit()')
      const { userid, password } = this
      this.$emit('submit', { userid, password })
    }
  }
}
</script>

<style scoped>
  .login {
    margin-top: 10px;
  }
  input {
    margin: 10px 0;
    width: 30%;
    padding: 15px;
  }
  button {
    margin-top: 20px;
    width: 20%;
    cursor: pointer;
  }
  .border-styles > p{
    margin: 2px 0;
    padding: 1px 3px;
    border-width: 2px;
    border-color: #aaa;
  }
</style>
