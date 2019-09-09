<template>
    <div class="page-container">
        <md-app md-waterfall md-mode="overlap">
            <md-app-toolbar class="md-primary md-large">
                <div class="md-toolbar-row">
                    <md-button class="md-icon-button" @click="menuVisible = !menuVisible">
                        <md-icon>menu</md-icon>
                    </md-button>

                    <span class="md-title"><strong>Q5 CALCULATOR</strong></span>
                </div>
            </md-app-toolbar>

            <md-app-drawer :md-active.sync="menuVisible">
                <md-toolbar class="md-transparent" md-elevation="0">
                    Navigation
                </md-toolbar>

                <md-list>
                    <md-ripple>
                        <md-list-item>
                            <md-icon>move_to_inbox</md-icon>
                            <span class="md-list-item-text">Calculator</span>
                        </md-list-item>
                    </md-ripple>

                    <md-ripple>
                        <md-list-item @click="info = true">
                            <md-icon>error</md-icon>
                            <span class="md-list-item-text">info</span>

                            <md-dialog-alert
                                    :md-active.sync="info"
                                    md-title="Hi!"
                                    md-content="I am <strong>Yi Ming (1705040217)</strong> who comes from <strong>IoT class 2</strong>. I made this with <strong>electron</strong> and <strong>vue</strong>. Hope you like it!" />

                        </md-list-item>
                    </md-ripple>
                </md-list>

            </md-app-drawer>



            <md-app-content>
                <div>
                    <Calculator></Calculator>
                </div>
            </md-app-content>
        </md-app>
    </div>
</template>

<style lang="scss" scoped>

    .md-app {
        height: 100vh;
        width: 100vw;
        .md-app-scroller {
            margin-top: 0px;
        }
    }

    // Demo purposes only
    .md-drawer {
        width: 230px;
        max-width: calc(100vw - 125px);
    }
</style>

<script>
    import Calculator from '../components/Calculator'

    export default {
      name: 'Homepage',
      components: {
        Calculator
      },
      data: () => ({
        menuVisible: false,
        info: false
      })
    }
</script>
