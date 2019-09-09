<template>
    <div>
        <div class="md-layout md-gutter">
            <div class="md-layout-item">
                <Results ref="results"></Results>
            </div>
            <div class="md-layout-item">
                <Forms ref="forms"></Forms>
            </div>
        </div>
    </div>
</template>

<script>
    import Forms from '../components/Forms'
    import Results from '../components/Results'

    export default {
      name: 'Calculator',
      components: {
        Forms,
        Results
      },
      data: () => ({
        preset: null,
        income: null,
        year: null,
        bit_number: null,
        instructions: null,
        Memory: null,
        Price: null,
        Cost: null
      }),
      methods: {
        calculate () {
          this.fetchProperties()
          this.calculateM()
          this.calculateP()
          this.calculateC()
          this.$refs.results.display()
        },
        fetchProperties () {
          this.preset = this.$refs.forms.preset
          this.income = this.$refs.forms.income
          this.year = this.$refs.forms.year
          this.bit_number = this.$refs.forms.bit_number
          this.instructions = this.$refs.forms.instructions
        },
        calculateM () {
          this.Memory = 4080 * Math.exp(0.28 * (this.year - 1960))
        },
        calculateP () {
          if (Forms.data().bit_number === 16) {
            this.Price = this.Memory * 0.048 * Math.pow(0.72, (this.year - 1974))
          } else {
            this.Price = this.Memory * 0.3 * Math.pow(0.72, (this.year - 1974)) * this.bit_number / 100
          }
        },
        calculateC () {
          this.Cost = this.income * this.Memory / this.instructions
        }
      }
    }
</script>

<style lang="scss" scoped>
</style>
