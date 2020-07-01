import AppLoading from "../../partials/app-loading/app-loading.vue"

export default {
    data() {
        return{
            user:{

            },
            isLoading: false
        }
    },
    created() {
        this.isLoading = true
        this.$http
        .get(process.env.VUE_APP_BASE_URI + "users")
        .then((resposta) => resposta.json())
        .then(
          (response) => {
              this.user = response
              this.isLoading = false
          },
          () => {
            this.$toast.error("Erro ao buscar a frase do dia")
            this.isLoading = false
          },
        )
    },
    components: {
        "app-loading": AppLoading,
    },
}
