<template>
  <Layout>
    <template #menubar>
    <!-- 메뉴[툴바] -->
      <v-btn @click="start('domestic')" text color="black" style="padding: 10px; width: 90px;">국내</v-btn>

      <v-btn @click="start('global')" text color="black" style="padding: 10px; width: 90px;">해외</v-btn>

      <v-btn @click="start('news#economy')" text color="black" style="padding: 10px; width: 90px;">뉴스</v-btn>

      <v-btn @click="start('exchange')" text color="black" style="padding: 10px; width: 90px;">환율</v-btn>

      <v-btn @click="start('talks')" text color="black" style="padding: 10px; width: 90px;">게시판</v-btn>

    </template>
    <template #content>
    <!-- 게시판 -->
    <v-container fluid>
      <v-img src="@/assets/homeG.png" max-height="70px"></v-img>
    </v-container>
      <v-simple-table>
        <template v-slot:default>
          <thead>
            <tr>
            <!-- 목록 -->
              <th class="text-left">No.</th>
              <th class="text-left">제목</th>
            </tr>
          </thead>
          <!-- 크롤링 한 값을 가져옴 [클릭할 때 작동] -->
          <tbody>
            <tr v-for="list of lists" :key="list.title">
              <td style="color: gray">{{ list.newsNo }}</td>
              <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </template>
  </Layout>
</template>

<script>
import Layout from '../components/Layout'
import { mapState } from 'vuex'

export default {
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
