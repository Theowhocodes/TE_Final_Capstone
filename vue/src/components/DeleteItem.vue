<template>
  <div>
    <div class="delete-item">
      <button
        type="button"
        v-on:click="deleteItem()"
        name="deleteItem"
        id="deleteItem"
      >
        Delete
      </button>
    </div>
  </div>
</template>

<script>
import itemService from "../services/ItemService";

export default {
  name: "deleteItem",
  methods: {
      deleteItem() {
          const itemId = this.$route.params.itemId;
          itemService.deleteItem(itemId).then(response => {
              if(response.status === 200) {
                  this.$router.go(-1)
              }
          })
      }
  },
};
</script>

<style>
</style>