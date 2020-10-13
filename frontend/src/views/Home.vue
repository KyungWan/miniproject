<template>
  <Layout>
    <template #content>
    <!-- 파일 이름 길이 자르기 = truncate-length
         줄 밑부분 정보 표시 = counter
         파일 크기 표시 = show size -->
    <v-container>
        <v-file-input
          chips
          counter
          show-size
          outlined
          truncate-length="50"
          placeholder="Please upload music files."
        >
        </v-file-input>
      </v-container>

      <div align="center">
        <v-btn outlined next to="/analysis" color="gray"
               style="padding: auto width: auto">
          분석 결과 보기
        </v-btn>
      </div>
    </template>
  </Layout>
</template>

<script>
import Layout from '../components/Layout'
import { mapGetters } from 'vuex'

// @ is an alias to /src
/* eslint-disable no-unused-vars */
import store from '../store'
import Vue from 'vue'
import router from '../router'

export default {
  components: { Layout },
  methods: {
    Success () {
      (window.location.pathname !== '/Music') ? router.push('/Music') : router.go(0)
    }
  },
  computed: {
    ...mapGetters(['isAuthorized'])
  }
}
</script>

<style>
  .border-styles > p{
    margin: 2px 0;
    padding: 1px 3px;
    border-width: 2px;
    border-color: #aaa;
  }
  body {
    font-family: Helvetica Neue, Arial, sans-serif;
    font-size: 14px;
    color: #444;
  }

  table {
    border: 2px solid #42b983;
    border-radius: 3px;
    background-color: #fff;
  }

  th {
    background-color: #42b983;
    color: rgba(255, 255, 255, 0.66);
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -user-select: none;
  }

  td {
    background-color: #f9f9f9;
  }

  th,
  td {
    min-width: 120px;
    padding: 10px 20px;
  }
</style>
