<template>
  <v-container fluid>
    <v-img src="@/assets/Login.png" max-height="350px"></v-img>
  <div align="center">
    <h2>Login</h2>
    <login-form @submit="onSubmit"/>
  </div>
  </v-container>
</template>

<script>
import LoginForm from '@/components/LoginForm.vue'
import { mapActions } from 'vuex'

export default {
  name: 'LoginPage',
  components: {
    LoginForm
  },
  methods: {
    onSubmit (payload) {
      console.log('loginPage onSubmit()')
      this.login(payload).then(res => {
        alert('Login Success')
        this.$router.push({ name: 'Music' })
      }).catch(err => {
        // alert(err.response.data.message)
        alert('Something Fail: ', err)
      })
    },
    ...mapActions(['login'])
  }
}
</script>
