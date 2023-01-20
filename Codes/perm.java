// 순열 nPr
static void Permutation(int cnt, boolean[] v, int[] nums) {
  if(cnt == r)
    return;

  for(int i=0; i<n; i++) {
    if(v[i]) continue;

    nums[cnt]=i;
    v[i]=true;
    Permutation(cnt+1, v, nums);
    v[i]=false;
  }
}
