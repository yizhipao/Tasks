<template>
    <div>
            <md-card md-with-hover>
            <md-ripple>
                <md-card-header>
                    <div class="md-title">
                        {{Memory}}
                        <span class="md-suffix">Byte</span>
                    </div>

                    <div class="md-subhead">Memory</div>
                </md-card-header>

            </md-ripple>
        </md-card>

            <md-card md-with-hover>
                <md-ripple>
                    <md-card-header>
                        <div class="md-title">
                            <span class="md-prefix">$</span>
                            {{Price}}
                            <span class="md-suffix">/ word</span>
                        </div>
                        <div class="md-subhead">Price</div>
                    </md-card-header>

                </md-ripple>
            </md-card>

            <md-card md-with-hover>
                <md-ripple>
                    <md-card-header>
                        <div class="md-title">
                            <span class="md-prefix">$</span>
                            {{Cost}}
                        </div>
                        <div class="md-subhead">Cost</div>
                    </md-card-header>

                </md-ripple>
            </md-card>
    </div>
</template>

<script>
    export default {
      name: 'Results',
      data: () => ({
        Memory: null,
        Price: null,
        Cost: null
      }),
      methods: {
        display () {
          this.Memory = this.$parent.Memory
          this.Price = this.$parent.Price
          this.Cost = this.$parent.Cost
        }
      }
    }
</script>

<style lang="scss" scoped>
    .md-card {
        height: auto;
        margin-bottom: 1vh;
        margin-bottom: 6vh;
        height: 24vh;
    }

</style>
