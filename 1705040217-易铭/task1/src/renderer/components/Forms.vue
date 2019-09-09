<template>
    <div>
        <div>

            <md-field>
                <label>Year</label>
                <md-input v-model="year"></md-input>
            </md-field>

            <md-field>
                <label>The number of instructions</label>
                <md-input v-model="instructions"></md-input>
            </md-field>

            <md-field>
                <label for='bit_number'>The number of bits</label>
                <md-select v-model="bit_number" name="bit_number" id="bit_number">
                    <md-option value="16">16-bits</md-option>
                    <md-option value="32">32-bits</md-option>
                </md-select>
            </md-field>

            <md-field>
                <label>Average Income</label>
                <span class="md-prefix">$</span>
                <md-input v-model="income"></md-input>
            </md-field>

        </div>

        <div class="md-layout">
            <div class="md-layout-item">
                <md-switch v-model="preset" @change="onPreset">Using Preset</md-switch>
                <md-switch v-model="q3" @change="onQ3">Question 3</md-switch>
            </div>
            <div class="md-layout-item">
                <md-button id="calculator" class="md-raised md-primary" @click="calculate">Calculate</md-button>
            </div>        </div>
        <p>Property:</p>
        <div v-if="preset === false">
            year = {{year}}
            bit_number = {{bit_number}}
            instructions = {{instructions}}
            income = {{income}}
        </div>
        <div v-else>
            year = {{year}}
            bit_number = {{bit_number}}
            instructions = {{instructions}}
            income = {{income}}

        </div>
        </div>
</template>

<script>
    export default {
      name: 'Forms',
      data: () => ({
        income: null,
        year: null,
        preset: false,
        bit_number: null,
        instructions: null,
        temp_income: null,
        temp_year: null,
        temp_bit_number: null,
        temp_instructions: null,
        q3: false
      }),
      methods: {
        onPreset () {
          if (this.preset === true) {
            this.temp_income = this.income
            this.temp_instructions = this.instructions
            this.temp_bit_number = this.bit_number
            this.temp_year = this.year
            this.onQ3()
          } else {
            this.q3 = false
            this.income = this.temp_income
            this.instructions = this.temp_instructions
            this.bit_number = this.temp_bit_number
            this.year = this.temp_year
          }
        },
        onQ3 () {
          if (this.preset === true) {
            if (this.q3 === true) {
              this.income = 6000
              this.instructions = 30
              this.bit_number = 32
              this.year = 1995
            } else {
              this.income = 4000
              this.instructions = 10
              this.bit_number = 16
              this.year = 1985
            }
          } else {
            this.q3 = false
          }
        },
        calculate () {
          this.$parent.calculate()
        }
      }
    }
</script>

<style lang="scss" scoped>
    #calculator {
        width: 20vw;
    }
</style>
