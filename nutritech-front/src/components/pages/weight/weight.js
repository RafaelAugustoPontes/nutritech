import AppLoading from "../../partials/app-loading/app-loading.vue"

export default {
	data() {
		return {
			weights: [],
			form: {
				value: 60,
				date: "",
			},

			isLoading: false,
		}
	},
	created() {
		this.getWeights()
	},

	methods: {
		excluir(id) {
			this.isLoading = true
			this.$http
				.delete(process.env.VUE_APP_BASE_URI + `weigths/${id}`)
				.then(
					() => {
						this.isLoading = false
						this.getWeights()
					},
					() => {
						this.isLoading = false
					},
				)
		},

		getWeights() {
			this.isLoading = true
			this.$http
				.get(process.env.VUE_APP_BASE_URI + "weigths")
				.then((resposta) => resposta.json())
				.then(
					(response) => {
						this.weights = response
						this.isLoading = false
					},
					() => {
						this.isLoading = false
					},
				)
		},

		cadastrar(event) {
			event.preventDefault();
			this.isLoading = true
			this.$http
				.post(process.env.VUE_APP_BASE_URI + "weigths", this.form)
				.then(
					() => {
						this.isLoading = false
						this.getWeights()
					},
					() => {
						this.isLoading = false
					},
				)
		},
	},

	components: {
		"app-loading": AppLoading,
	},
}
