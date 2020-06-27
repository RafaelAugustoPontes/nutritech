<template>
  <div id="app">
     <header id="header">
       <Menu :routes="routes" v-if="!hide"></Menu>
    </header>
     <main id="content">
      <router-view></router-view>
    </main>
  </div>
</template>

<script>
import { routes } from './routes.js';
import Menu from './components/partials/menu/menu.vue'

export default {
  name: 'App',
  components: {
    Menu,
  },
  data() {
    return {
      routes,
    };
  },
   computed: {
    hide() {
      return this.$route.path === '/login' || this.$route.path === '/' || this.$route.path === '/sign-up';
    },
  },
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: black;
  margin-top: 60px;
}

#header {
  padding: 10px;
  text-align: center;
  font-size: 20px;
}

#content {
  -webkit-flex: 3;
  -ms-flex: 3;
  flex: 3;
  padding: 10px;
  width: 58%;
  margin: 0 auto;
}

.card-title{
	color: #007bff;
}
</style>
