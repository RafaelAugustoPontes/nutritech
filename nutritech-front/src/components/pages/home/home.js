import AppLoading from "../../partials/app-loading/app-loading.vue"

export default {
	data: function() {
		return {
			options: {},
			series: [],
			isLoading: false,
			motivationalQuote: {},
			imc: {},
		}
	},

	created() {
		this.isLoading = true
		this.generateChart()
		this.getMotivationalQuote()
		this.getImc()
	},

	methods: {
		generateChart() {
			this.$http
				.get(process.env.VUE_APP_BASE_URI + "weigths")
				.then((resposta) => resposta.json())
				.then(
					(weights) => {
						let weightsValues = []
						let categoriesValues = []
						weights.forEach((element) => {
							weightsValues.push(element.value)
							categoriesValues.push(element.formatedDate)
						})

						this.series.push({
							name: "Peso",
							data: [...weightsValues],
						})

						this.options = {
							chart: {
								id: "weights",
							},
							xaxis: {
								categories: [...categoriesValues],
							},
						}

						this.isLoading = false
					},
					() => {
						this.$toast.error("Erro ao buscar os pesos")
						this.isLoading = false
					},
				)
		},

		getMotivationalQuote() {
			this.$http
				.get(process.env.VUE_APP_BASE_URI + "motivational-quotes")
				.then((resposta) => resposta.json())
				.then(
					(motivationalQuote) => {
						this.motivationalQuote = motivationalQuote
					},
					() => {
						this.$toast.error("Erro ao buscar a frase do dia")
						this.isLoading = false
					},
				)
		},

		getImc() {
			this.$http
				.get(process.env.VUE_APP_BASE_URI + "users/imc")
				.then((resposta) => resposta.json())
				.then(
					(imc) => {
						this.imc = imc
					},
					() => {
						this.$toast.error("Erro ao buscar a frase do dia")
						this.isLoading = false
					},
				)
		},

		generateDiet() {
			this.$http
				.get(process.env.VUE_APP_BASE_URI + "diets")
				.then((resposta) => resposta.json())
				.then(
					(diet) => {
						window.open(
							diet.url,
							"_blank", // <- This is what makes it open in a new window.
						)
					},
					() => {
						this.$toast.error("Erro ao buscar a dieta")
						this.isLoading = false
					},
				)
		},
	},

	components: {
		"app-loading": AppLoading,
	},
}
