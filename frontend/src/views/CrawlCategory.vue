<template>
  <Layout>
    <template #menubar>
    <!-- 메뉴[툴바] -->
      <v-btn @click="start('economic')" text color="black" style="padding: 10px; width: 90px;">국내 경제</v-btn>

      <v-btn @click="start('foreign')" text color="black" style="padding: 10px; width: 90px;">해외 소식</v-btn>

      <v-btn @click="start('news#economy')" text color="black" style="padding: 10px; width: 90px;">뉴스</v-btn>

      <v-btn @click="start('exchange')" text color="black" style="padding: 10px; width: 90px;">환율</v-btn>

    </template>
    <template #content>
    <!-- 게시판 -->
    <v-container>
      <v-text-field v-model="search" single-line></v-text-field>
        <v-data-table style="width: auto"
                      :headers="headers"
                      :items="lists"
                      :items-per-page="5"
                      :search="search">
         <template #item.title="{ item }">
            <a :href="item.address" target=_blank>{{ item.title }}</a>
         </template>
        </v-data-table>
      </v-container>
    </template>
  </Layout>
</template>

<script>
import Layout from '../components/Layout'
import { mapState } from 'vuex'

export default {
  name: 'App',
  data: () => ({
    search: '',
    headers: [
      { text: 'No.', value: 'newsNo' },
      { text: '제목', value: 'title' }
    ]
  }),
  components: { Layout },
  computed: {
    ...mapState({
      lists: state => state.lists
    })
  },
  methods: {
    clickNews (newsNo) {
      console.log('clickNews: ' + newsNo)
      this.$store.dispatch('crawlFindOne', newsNo)
    },
    start (category) {
      this.$store.dispatch('crawlFind', category)
    }
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

  #search {
    margin-bottom: 10px;
  }
</style>
