import AppLoading from '../../partials/app-loading/app-loading.vue';
import Vue from 'vue';

export default {
  components: { AppLoading, },
  created() {
  },
  data() {
    return {
      form: {
        username: '',
        password: '',
      },
      isLoading: false,
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      this.isLoading = true;
      this.$http.post(process.env.VUE_APP_BASE_URI + 'auth', this.form).then(
        response => {
          if (response.status === 200) {
            sessionStorage.setItem('jwt', response.body.token);
            sessionStorage.setItem('username', response.body.username);
            Vue.http.headers.common['Authorization'] = response.body.token;
            this.$router.push('/home');
          }
          this.isLoading = false;
        },
        erro => {
          console.log(erro)
          this.$toast.error('Login ou senha inválido' );
          this.isLoading = false;
        }
      );
    },

    goToSignUp(){
      this.$router.push('/sign-up');
    }

  },
};